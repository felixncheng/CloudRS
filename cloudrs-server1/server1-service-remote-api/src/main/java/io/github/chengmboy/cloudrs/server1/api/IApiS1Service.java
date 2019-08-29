package io.github.chengmboy.cloudrs.server1.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author cheng_mboy
 */
@FeignClient(ApiConstants.Server1)
public interface IApiS1Service {

    @GetMapping("home/s1")
    String home();

    @GetMapping("hi")
    String hi();
}
