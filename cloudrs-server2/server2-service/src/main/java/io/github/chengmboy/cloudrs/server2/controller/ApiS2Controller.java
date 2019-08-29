package io.github.chengmboy.cloudrs.server2.controller;

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
public class ApiS2Controller implements IApiS2Service {

    @Value("${server.port}")
    String port;

    @Value("${spring.application.name}")
    String name;

    @Autowired
    IApiS1Service service1;


    @Override
    public String home() {
        log.info("invoke server1 feign service [{}]",service1.hi());
        return "hi "+name+",i am from port:" +port;
    }
}
