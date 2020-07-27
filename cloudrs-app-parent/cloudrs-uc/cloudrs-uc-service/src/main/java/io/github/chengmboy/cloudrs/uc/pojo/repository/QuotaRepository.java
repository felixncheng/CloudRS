package io.github.chengmboy.cloudrs.uc.pojo.repository;

import io.github.chengmboy.cloudrs.uc.pojo.entity.Quota;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author cheng_mboy
 */
public interface QuotaRepository extends JpaRepository<Quota,Long>{

    Quota findByProductCode(String code);
}
