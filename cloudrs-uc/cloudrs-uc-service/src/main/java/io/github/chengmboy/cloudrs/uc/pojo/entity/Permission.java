package io.github.chengmboy.cloudrs.uc.pojo.entity;

import io.github.chengmboy.cloudrs.common.web.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;



@Data
@Entity
public class Permission extends AbstractEntity {

    private String name;

    private String url;

    private String method;

}
