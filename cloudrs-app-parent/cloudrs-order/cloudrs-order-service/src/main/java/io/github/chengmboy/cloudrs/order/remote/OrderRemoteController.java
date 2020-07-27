package io.github.chengmboy.cloudrs.order.remote;

import io.github.chengmboy.cloudrs.common.web.Response;
import io.github.chengmboy.cloudrs.order.OrderRemoteService;
import io.github.chengmboy.cloudrs.order.dto.OrderDTO;
import io.github.chengmboy.cloudrs.order.service.OrderService;
import io.github.chengmboy.cloudrs.payment.api.BalanceRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRemoteController implements OrderRemoteService {

    @Autowired
    OrderService orderService;
    @Autowired
    BalanceRemoteService balanceRemoteService;

    @Override
    public Response<OrderDTO> create(@RequestParam Long userId, @RequestParam String code, @RequestParam int count) {
        OrderDTO order = orderService.createOrder(userId, code, count);
        balanceRemoteService.freeze(1L);
        return Response.ok(order);
    }
}
