package io.github.chengmboy.cloudrs.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class IndexController {

    @Autowired
    private SwaggerResourcesProvider resourcesProvider;


    @GetMapping("")
    public void home(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("swagger-resources")
    public List<SwaggerResource> get() {
        return resourcesProvider.get();
    }
}
