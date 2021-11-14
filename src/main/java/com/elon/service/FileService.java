package com.elon.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件服务。通过读写本地文件，实现文件的上传，下载功能.
 *
 * @author elon
 * @since 2021-11-14
 */
@Component
public class FileService {
    private static final Logger LOGGER = LogManager.getLogger(FileService.class);

    private static final String FILE_PATH = System.getProperty("user.dir") + File.separator + "file" + File.separator;

    /**
     * 读取本地文件内容，返回字节数组。
     *
     * @param fileName 文件名(假定文件名是唯一的)
     * @return 字节数组
     * @author elon
     */
    public byte[] readFile(String fileName){
        String fullFilePath = FILE_PATH + fileName;
        List<byte[]> bufferFileByteList = new ArrayList<>();
        FileInputStream inputStream = null;

        try {
            inputStream = new FileInputStream(fullFilePath);
            byte[] buffer = new byte[1024];
            while (inputStream.read(buffer) != -1) {
                // 这里必须使用clone，否则bufferFileByteList中存储的都是最后一批读取的数据。因数组是对象引用.
                bufferFileByteList.add(buffer.clone());
            }

            // 构造整个文件的字节数组返回
            int byteAmount = bufferFileByteList.stream().mapToInt(bytes -> bytes.length).sum();
            byte[] fileByte = new byte[byteAmount];

            int index = 0;
            for (byte[] bufferArray : bufferFileByteList) {
                System.arraycopy(bufferArray, 0, fileByte, index, bufferArray.length);
                index += bufferArray.length;
            }

            return fileByte;

        } catch (Exception e) {
            LOGGER.info("Read file exception.", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    LOGGER.info("Close file exception.", e);
                }
            }
        }

        return null;
    }
}
