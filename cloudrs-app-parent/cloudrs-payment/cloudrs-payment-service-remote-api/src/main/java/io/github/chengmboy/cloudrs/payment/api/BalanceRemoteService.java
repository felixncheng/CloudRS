package io.github.chengmboy.cloudrs.payment.api;

import java.math.BigDecimal;

/**
 * @author cheng_mboy
 */
public interface BalanceRemoteService {

    /**
     *
     * 冻结金额
     * @param userId 用户Id
     *               @param num 冻结金额
     * */
    void freeze(Long userId, BigDecimal num);


    /**
     * 扣减冻结金额
     * @param freezeId 冻结金额id
     * */
    void deduct(Long freezeId);
}
