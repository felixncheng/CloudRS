package io.github.chengmboy.cloudrs.uc.api;

import io.github.chengmboy.cloudrs.uc.api.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author cheng_mboy
 */
@FeignClient("uc")
public interface UserRemoteService {

    @GetMapping("/user/login/{loginName}")
    UserDTO getByLoginName(@PathVariable("loginName") String loginName);
}
