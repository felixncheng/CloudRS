package io.github.chengmboy.cloudrs.order.service;

import io.github.chengmboy.cloudrs.order.dto.OrderDTO;

public interface OrderService {

    OrderDTO createOrder(Long userId,String code,int count);
}
