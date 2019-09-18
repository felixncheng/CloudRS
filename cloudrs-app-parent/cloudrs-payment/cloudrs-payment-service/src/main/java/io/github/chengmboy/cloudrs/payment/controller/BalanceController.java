package io.github.chengmboy.cloudrs.payment.controller;

import java.math.BigDecimal;

import io.github.chengmboy.cloudrs.common.exception.EntityAlreadyExistException;
import io.github.chengmboy.cloudrs.common.exception.EntityNotFoundException;
import io.github.chengmboy.cloudrs.common.web.Response;
import io.github.chengmboy.cloudrs.payment.pojo.dto.BalanceDTO;
import io.github.chengmboy.cloudrs.payment.service.BalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cheng_mboy
 */
@RestController
@RequestMapping("payment/balance")
@RequiredArgsConstructor
public class BalanceController {

    final BalanceService balanceService;

    @PostMapping("pay")
    public Response<BalanceDTO> pay(@RequestParam Long balanceId, @RequestParam BigDecimal num) throws EntityNotFoundException {
        BalanceDTO balance = balanceService.pay(balanceId, num);
        return Response.ok(balance);
    }

    @PostMapping("create")
    public  Response<BalanceDTO> create(@RequestParam Long userId) throws EntityAlreadyExistException {
        BalanceDTO balance = balanceService.create(userId);
        return Response.ok(balance);
    }
}
