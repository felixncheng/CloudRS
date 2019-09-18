package io.github.chengmboy.cloudrs.payment.service.impl;

import java.math.BigDecimal;

import io.github.chengmboy.cloudrs.common.exception.EntityAlreadyExistException;
import io.github.chengmboy.cloudrs.common.exception.EntityNotFoundException;
import io.github.chengmboy.cloudrs.payment.exception.OutOfMoneyException;
import io.github.chengmboy.cloudrs.payment.pojo.dto.BalanceDTO;
import io.github.chengmboy.cloudrs.payment.pojo.entity.Balance;
import io.github.chengmboy.cloudrs.payment.pojo.entity.FreezeBalance;
import io.github.chengmboy.cloudrs.payment.pojo.repository.BalanceRepository;
import io.github.chengmboy.cloudrs.payment.service.BalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @author cheng_mboy
 */
@Service
@RequiredArgsConstructor
public class BalanceServiceImpl implements BalanceService {

    final BalanceRepository balanceRepository;

    @Override
    public BalanceDTO freeze(Long balanceId, BigDecimal num) throws OutOfMoneyException {
        //锁定账户
        Balance balance = balanceRepository.getOne(balanceId);

        //检查余额是否足够
        if (balance.getBalance().compareTo(num) < 0) {
            throw new OutOfMoneyException();
        }
        FreezeBalance freezeBalance = new FreezeBalance();
        freezeBalance.setBalance(balance);
        freezeBalance.setFreeze(num);
        BalanceDTO balanceDTO = new BalanceDTO();
        BeanUtils.copyProperties(balance ,balanceDTO);
        return balanceDTO;
    }

    @Override
    public void deduct(Long freezeId) {

    }

    @Override
    public BalanceDTO pay(Long balanceId, BigDecimal num) throws EntityNotFoundException {
        Balance balance = balanceRepository.getOne(balanceId);
        if (balance == null) {
            throw new EntityNotFoundException();
        }
        BigDecimal current = balance.getBalance().add(num);
        balance.setBalance(current);
        balanceRepository.save(balance);
        BalanceDTO balanceDTO = new BalanceDTO();
        BeanUtils.copyProperties(balance ,balanceDTO);
        return balanceDTO;
    }

    @Override
    public BalanceDTO create(Long userId) throws EntityAlreadyExistException {
        Balance balance = balanceRepository.findByUserId(userId);
        if (balance != null) {
            throw new EntityAlreadyExistException();
        }
        balance = new Balance();
        balance.setUserId(userId);
        balanceRepository.save(balance);
        BalanceDTO balanceDTO = new BalanceDTO();
        BeanUtils.copyProperties(balance ,balanceDTO);
        return balanceDTO;
    }
}
