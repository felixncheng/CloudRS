package io.github.chengmboy.cloudrs.ram.pojo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author cheng_mboy
 */
@Data
@Entity
public class User {
    @Id
    private Long id;

    private String name;

    private String email;

    private String phone;
}
