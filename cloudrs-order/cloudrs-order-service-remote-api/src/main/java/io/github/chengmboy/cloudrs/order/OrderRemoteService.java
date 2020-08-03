package io.github.chengmboy.cloudrs.order;

import io.github.chengmboy.cloudrs.common.web.Response;
import io.github.chengmboy.cloudrs.order.constants.OrderConstants;
import io.github.chengmboy.cloudrs.order.dto.OrderDTO;
import io.swagger.annotations.Api;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(OrderConstants.CloudRsPayment)
@Api("订单服务")
public interface OrderRemoteService {

    @PostMapping("/order/create")
    Response<OrderDTO> create(@RequestParam Long userId, @RequestParam String code, @RequestParam int count);
}
