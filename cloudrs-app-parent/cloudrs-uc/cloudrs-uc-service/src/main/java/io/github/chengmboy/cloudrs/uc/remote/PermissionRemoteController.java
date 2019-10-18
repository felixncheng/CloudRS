package io.github.chengmboy.cloudrs.uc.remote;

import io.github.chengmboy.cloudrs.uc.api.PermissionRemoteService;
import io.github.chengmboy.cloudrs.uc.api.dto.PermissionDTO;
import io.github.chengmboy.cloudrs.uc.pojo.entity.Permission;
import io.github.chengmboy.cloudrs.uc.pojo.entity.Role;
import io.github.chengmboy.cloudrs.uc.pojo.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class PermissionRemoteController implements PermissionRemoteService {

    private final RoleRepository roleRepository;
    @Override
    public Set<PermissionDTO> findPermissionByRoleCode(String roleCode) {

        Set<PermissionDTO> permissionDTOS = new HashSet<>();
        Role role = roleRepository.findByRoleCode(roleCode);
        if (role != null) {
            List<Permission> permissions = role.getPermissions();
            for (Permission permission : permissions) {
                PermissionDTO permissionDTO = new PermissionDTO();
                BeanUtils.copyProperties(permission,permissionDTO);
                permissionDTOS.add(permissionDTO);
            }
        }
        return permissionDTOS;
    }
}
