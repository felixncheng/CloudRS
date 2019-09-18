package io.github.chengmboy.cloudrs.payment.service;

import java.math.BigDecimal;

import io.github.chengmboy.cloudrs.common.exception.EntityAlreadyExistException;
import io.github.chengmboy.cloudrs.common.exception.EntityNotFoundException;
import io.github.chengmboy.cloudrs.payment.exception.OutOfMoneyException;
import io.github.chengmboy.cloudrs.payment.pojo.dto.BalanceDTO;

/**
 * @author cheng_mboy
 */
public interface BalanceService {

    /**
     *
     * 冻结金额
     * @param balanceId 用户账户余额Id
     *               @param num 冻结金额
     * */
    BalanceDTO freeze(Long balanceId, BigDecimal num) throws OutOfMoneyException;


    /**
     * 扣减冻结金额
     * @param freezeId 冻结金额id
     * */
    void deduct(Long freezeId);

    /**
     * 充值
     */
    BalanceDTO pay(Long balanceId, BigDecimal num) throws EntityNotFoundException;

    /**
     * 创建账户
     */
    BalanceDTO create(Long userId) throws EntityAlreadyExistException;
}
