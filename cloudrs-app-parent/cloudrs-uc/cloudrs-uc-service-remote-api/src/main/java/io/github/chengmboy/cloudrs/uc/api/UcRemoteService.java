package io.github.chengmboy.cloudrs.uc.api;


import io.github.chengmboy.cloudrs.uc.api.constants.UcConstants;
import io.github.chengmboy.cloudrs.uc.api.dto.PermissionDTO;
import io.github.chengmboy.cloudrs.uc.api.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

@FeignClient(UcConstants.Uc)
public interface UcRemoteService {

    @GetMapping("/permission/{roleCode}")
    Set<PermissionDTO> findPermissionByRoleCode(@PathVariable("roleCode") String roleCode);

    @GetMapping("/user/login/{loginName}")
    UserDTO getByLoginName(@PathVariable("loginName") String loginName);
}
