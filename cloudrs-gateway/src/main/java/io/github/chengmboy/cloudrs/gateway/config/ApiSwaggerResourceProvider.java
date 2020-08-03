package io.github.chengmboy.cloudrs.gateway.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
@Primary
public class ApiSwaggerResourceProvider implements SwaggerResourcesProvider {

    public static final String SWAGGER2URL = "/v2/api-docs";

    private final RouteLocator routeLocator;

    private final ZuulProperties properties;

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> list = new ArrayList<>();

        for (Route route : routeLocator.getRoutes()) {
            String fullPath = route.getFullPath();
            String id = route.getId();
            SwaggerResource resource = swaggerResource(id, fullPath.replace("/**", SWAGGER2URL));
            list.add(resource);
        }
        return list;
    }

    private SwaggerResource swaggerResource(String name, String location) {
        log.info("api server [{}] location[{}]",name,location);
        SwaggerResource resource = new SwaggerResource();
        resource.setName(name);
        resource.setLocation(location);
        return resource;
    }
}
