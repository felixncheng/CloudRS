package io.github.chengmboy.cloudrs.order.pojo.entity;

import io.github.chengmboy.cloudrs.common.web.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "order_tbl")
@Data
public class Order extends AbstractEntity {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "money")
    private BigDecimal money;

    @Column(name = "count")
    private Integer count;
}
