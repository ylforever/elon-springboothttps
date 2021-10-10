package com.elon.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    @GetMapping("/get")
    @ApiOperation(value = "GET方法")
    public String getMethod(@RequestParam(value = "param") String param){
        LOGGER.info("param:{}", param);
        return param;
    }

    @PostMapping("/post")
    @ApiOperation(value = "POST方法")
    public String postMethod(@RequestBody String param){
        LOGGER.info("param:{}", param);
        return param;
    }
}
