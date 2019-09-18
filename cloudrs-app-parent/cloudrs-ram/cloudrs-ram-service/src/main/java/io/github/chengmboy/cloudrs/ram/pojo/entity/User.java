package io.github.chengmboy.cloudrs.ram.pojo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import io.github.chengmboy.cloudrs.common.web.entity.AbstractEntity;
import io.github.chengmboy.cloudrs.common.web.entity.IdEntity;
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

    @Column(nullable = false,length = 20)
    private  String loginName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String salt;
}
