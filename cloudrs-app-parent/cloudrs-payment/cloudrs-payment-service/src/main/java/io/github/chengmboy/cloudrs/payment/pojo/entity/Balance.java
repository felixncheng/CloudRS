package io.github.chengmboy.cloudrs.payment.pojo.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;

import com.alibaba.fastjson.JSONObject;
import io.github.chengmboy.cloudrs.common.web.entity.AbstractEntity;
import lombok.Data;

/**
 * @author cheng_mboy
 */
@Data
@Entity
public class Balance extends AbstractEntity{

    private Long userId;

    @Column(precision = 10,scale = 2)
    private BigDecimal balance;

}
