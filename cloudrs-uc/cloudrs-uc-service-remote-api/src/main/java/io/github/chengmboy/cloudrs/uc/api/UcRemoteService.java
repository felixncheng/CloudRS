package io.github.chengmboy.cloudrs.uc.api;


import io.github.chengmboy.cloudrs.uc.api.constants.UcConstants;
import io.github.chengmboy.cloudrs.uc.api.dto.PermissionDTO;
import io.github.chengmboy.cloudrs.uc.api.dto.UserDTO;
import io.github.chengmboy.cloudrs.uc.api.fallback.UcRemoteFallbackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@FeignClient(value = UcConstants.CloudRsUc,fallback = UcRemoteFallbackImpl.class)
public interface UcRemoteService {

    @GetMapping("/permission/{roleCode}")
    Set<PermissionDTO> findPermissionByRoleCode(@PathVariable("roleCode") String roleCode);

    @GetMapping("/user/login/{loginName}")
    UserDTO getByLoginName(@PathVariable("loginName") String loginName);

    @PutMapping
    void deduct(@RequestParam String code, @RequestParam int count);
}
