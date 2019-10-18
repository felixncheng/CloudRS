package io.github.chengmboy.cloudrs.uc.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class RoleDTO implements Serializable {

    private String roleCode;

    private String name;

    List<PermissionDTO> permissions;
}
