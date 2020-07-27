package io.github.chengmboy.cloudrs.uc.pojo.entity;

import io.github.chengmboy.cloudrs.common.web.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Quota extends AbstractEntity {
    private String productCode;
    private Integer count;
}
