package io.github.chengmboy.cloudrs.resource.controller;

import io.github.chengmboy.cloudrs.resource.service.ResourceService;
import io.seata.spring.annotation.GlobalTransactional;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    @Autowired
    ResourceService resourceService;

    @GlobalTransactional
    @PostMapping
    public boolean create() {
        resourceService.create(1001L, "Elb", 1);
        return true;
    }
}
