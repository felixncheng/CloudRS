package io.github.chengmboy.cloudrs.server1.controller;

import io.github.chengmboy.cloudrs.server1.api.IApiS1Service;
import io.github.chengmboy.cloudrs.server2.api.IApiS2Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cheng_mboy
 */
@RestController
@Slf4j
public class ApiS1Controller implements IApiS1Service {

    @Value("${server.port}")
    String port;

    @Value("${spring.application.name}")
    String name;

    @Autowired
    IApiS2Service service2;

    @Override
    public String home() {
        log.info("invoke server2 feign service [{}]",service2.home());
        return "hi "+name+",i am from port:" +port;
    }

    @Override
    public String hi() {
        return "hi "+name+",i am from port:" +port;
    }
}
