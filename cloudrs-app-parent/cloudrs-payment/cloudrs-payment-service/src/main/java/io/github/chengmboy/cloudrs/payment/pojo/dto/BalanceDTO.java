package io.github.chengmboy.cloudrs.payment.pojo.dto;

import java.math.BigDecimal;

import lombok.Data;

/**
 * @author cheng_mboy
 */
@Data
public class BalanceDTO {

    private Long userId;

    private BigDecimal balance;

    private BigDecimal freezeBalance;
}
