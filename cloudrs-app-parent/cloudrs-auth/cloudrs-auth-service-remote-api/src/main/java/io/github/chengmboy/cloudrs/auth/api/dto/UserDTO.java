package io.github.chengmboy.cloudrs.auth.api.dto;

import lombok.Data;

/**
 * @author cheng_mboy
 */
@Data
public class UserDTO {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private String password;

    private String roles;
}
