package io.github.chengmboy.cloudrs.payment.pojo.entity;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

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
    private BigDecimal balance = BigDecimal.ZERO;

    @OneToMany(mappedBy = "balance")
    List<FreezeBalance> freezeBalances;

}
