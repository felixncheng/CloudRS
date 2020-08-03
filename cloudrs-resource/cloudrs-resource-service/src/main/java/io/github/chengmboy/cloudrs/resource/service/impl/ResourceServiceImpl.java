package io.github.chengmboy.cloudrs.resource.service.impl;

import io.github.chengmboy.cloudrs.order.OrderRemoteService;
import io.github.chengmboy.cloudrs.resource.service.ResourceService;
import io.github.chengmboy.cloudrs.uc.api.UcRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    public OrderRemoteService orderRemoteService;

    @Autowired
    UcRemoteService ucRemoteService;
    @Override
    public void create(Long userId, String code, int count) {
        ucRemoteService.deduct(code,count);
        orderRemoteService.create(userId,code,count);
    }
}
