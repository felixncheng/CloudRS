package io.github.chengmboy.cloudrs.payment.pojo.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import io.github.chengmboy.cloudrs.common.web.entity.AbstractEntity;
import lombok.Data;

/**
 * 冻结余额
 * @author cheng_mboy
 */
@Data
@Entity
public class FreezeBalance extends AbstractEntity{

    /**
     * 账户余额
     * */
    @ManyToOne
    private Balance balance;

    /**
     * 冻结数量
     * */
    private BigDecimal freeze;
}
