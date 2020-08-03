package io.github.chengmboy.cloudrs.order.service.impl;

import io.github.chengmboy.cloudrs.order.dto.OrderDTO;
import io.github.chengmboy.cloudrs.order.pojo.repository.OrderRepository;
import io.github.chengmboy.cloudrs.order.service.OrderService;
import io.github.chengmboy.cloudrs.order.pojo.entity.Order;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public OrderDTO createOrder(Long userId, String code, int count) {
        Order order = new Order();
        order.setUserId(userId);
        order.setCount(count);
        order.setProductCode(code);
        orderRepository.save(order);

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(order, orderDTO);

        return orderDTO;
    }
}
