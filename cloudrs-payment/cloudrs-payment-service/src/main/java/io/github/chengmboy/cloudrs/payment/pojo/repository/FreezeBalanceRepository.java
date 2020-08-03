package io.github.chengmboy.cloudrs.payment.pojo.repository;

import io.github.chengmboy.cloudrs.payment.pojo.entity.FreezeBalance;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author cheng_mboy
 */
public interface FreezeBalanceRepository  extends JpaRepository<FreezeBalance,Long>{

}
