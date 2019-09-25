package io.github.chengmboy.cloudrs.auth.api;

import io.github.chengmboy.cloudrs.auth.api.constants.AuthConstants;
import io.github.chengmboy.cloudrs.auth.api.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author cheng_mboy
 */
@FeignClient(AuthConstants.Auth)
public interface UserRemoteService {

    @GetMapping("auth/user/login/{loginName}")
    UserDTO getByLoginName(@PathVariable("loginName") String loginName);
}
