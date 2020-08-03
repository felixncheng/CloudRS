package io.github.chengmboy.cloudrs.uc.service;

public interface QuotaService {

    void deduct(String code,int count);

    void create(String code, int count);
}
