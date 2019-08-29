package io.github.chengmboy.cloudrs.server2.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author cheng_mboy
 */
@FeignClient(ApiConstants.Server2)
public interface IApiS2Service {

    @GetMapping("home/s2")
    String home();
}
