package com.elon.rest;

import com.elon.model.Result;
import com.elon.model.User;
import com.elon.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/https-controller")
@Api(tags = "HTTPS服务")
public class HttpsController {
    private static final Logger LOGGER = LogManager.getLogger(HttpsController.class);

    @Autowired
    private FileService fileService;

    @GetMapping("/get")
    @ApiOperation(value = "GET方法")
    public Result<User> getMethod(@RequestParam(value = "userName") String userName){
        LOGGER.info("userName:{}", userName);

        User user = new User();
        user.setName(userName);
        return Result.createSuccessResult(user);
    }

    @PostMapping("/post")
    @ApiOperation(value = "POST方法")
    public String postMethod(@RequestBody String param){
        LOGGER.info("param:{}", param);
        return param;
    }

    /**
     * 下载文件
     *
     * @param fileName 文件名(含扩展名)
     * @return 文件字节数组
     * @author yzy
     */
    @GetMapping("/download-file")
    @ApiOperation(value = "下载文件")
    public byte[] downloadFile(@RequestParam(value = "fileName") String fileName) {
        LOGGER.info("Invoke downloadFile begin. fileName:{}", fileName);
        byte[] bytes = fileService.readFile(fileName);
        LOGGER.info("Invoke downloadFile end. bytes size:{}", bytes.length);
        return bytes;
    }
}
