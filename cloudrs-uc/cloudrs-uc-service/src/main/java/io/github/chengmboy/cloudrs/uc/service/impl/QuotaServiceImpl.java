package io.github.chengmboy.cloudrs.uc.service.impl;

import io.github.chengmboy.cloudrs.uc.pojo.entity.Quota;
import io.github.chengmboy.cloudrs.uc.pojo.repository.QuotaRepository;
import io.github.chengmboy.cloudrs.uc.service.QuotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuotaServiceImpl implements QuotaService {

    @Autowired
    QuotaRepository quotaRepository;

    @Override
    public void deduct(String code,int count) {
        Quota quota = quotaRepository.findByProductCode(code);
        quota.setCount(quota.getCount()-count);
        quotaRepository.save(quota);
    }

    @Override
    public void create(String code, int count) {
        Quota quota = new Quota();
        quota.setProductCode(code);
        quota.setCount(count);
        quotaRepository.save(quota);
    }
}
