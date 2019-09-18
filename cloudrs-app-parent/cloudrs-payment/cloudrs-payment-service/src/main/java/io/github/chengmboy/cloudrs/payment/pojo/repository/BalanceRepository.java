package io.github.chengmboy.cloudrs.payment.pojo.repository;

import javax.persistence.LockModeType;

import io.github.chengmboy.cloudrs.payment.pojo.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

/**
 * @author cheng_mboy
 */
public interface BalanceRepository extends JpaRepository<Balance,Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Override
    Balance getOne(Long id);

    Balance findByUserId(Long userId);
}
