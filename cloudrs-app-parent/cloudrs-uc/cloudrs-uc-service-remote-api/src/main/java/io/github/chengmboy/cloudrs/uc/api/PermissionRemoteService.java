package io.github.chengmboy.cloudrs.uc.api;

import io.github.chengmboy.cloudrs.uc.api.dto.PermissionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

@FeignClient("uc")
public interface PermissionRemoteService {

    @GetMapping("/permission/{roleCode}")
    Set<PermissionDTO> findPermissionByRoleCode(@PathVariable("roleCode") String roleCode);
}
