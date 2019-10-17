package io.github.chengmboy.cloudrs.uc.pojo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import io.github.chengmboy.cloudrs.common.web.entity.AbstractEntity;
import lombok.Data;

/**
 * @author cheng_mboy
 */
@Data
@Entity
public class User extends AbstractEntity {

    private String name;

    private String email;

    private String phone;

    private String roles;

    @Column(nullable = false,length = 20)
    private  String loginName;

    @Column(nullable = false)
    private String password;

}
