package io.github.chengmboy.cloudrs.payment.controller;

import java.math.BigDecimal;
import io.github.chengmboy.cloudrs.common.exception.EntityAlreadyExistException;
import io.github.chengmboy.cloudrs.common.web.Response;
import io.github.chengmboy.cloudrs.payment.api.BalanceRemoteService;
import io.github.chengmboy.cloudrs.payment.api.dto.BalanceDTO;
import io.github.chengmboy.cloudrs.payment.api.exception.OutOfMoneyException;
import io.github.chengmboy.cloudrs.payment.service.BalanceService;
import io.github.chengmboy.cloudrs.auth.api.UserRemoteService;
import io.github.chengmboy.cloudrs.auth.api.dto.UserDTO;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

/**
 * @author cheng_mboy
 */
@RestController
@RequiredArgsConstructor
public class BalanceController implements BalanceRemoteService {

    final BalanceService balanceService;
    final UserRemoteService userRemoteService;

    @Override
    public Response<BalanceDTO> query(Jwt jwt) {
        String loginName = jwt.getSubject();
        UserDTO user = userRemoteService.getByLoginName(loginName);
        BalanceDTO balance = balanceService.query(user.getId());
        return Response.ok(balance);
    }

    @Override
    public Response<BalanceDTO> recharge(
            @ApiParam(required = true, value = "账户id")
            @RequestParam Long balanceId, @ApiParam(required = true, value = "充值金额") @RequestParam BigDecimal num){
        BalanceDTO balance = balanceService.recharge(balanceId, num);
        return Response.ok(balance);
    }

    @Override
    public Response<BalanceDTO> create(@RequestParam Long userId) throws EntityAlreadyExistException {
        BalanceDTO balance = balanceService.create(userId);
        return Response.ok(balance);
    }

    @Override
    public Response<BalanceDTO> freeze(@RequestParam Long balanceId, @RequestParam BigDecimal num) throws OutOfMoneyException {
        BalanceDTO balance = balanceService.freeze(balanceId, num);
        return Response.ok(balance);
    }

    @Override
    public Response freeze(@RequestParam Long freezeId){
        balanceService.deduct(freezeId);
        return Response.ok();
    }

    @Override
    public Response cancel(@RequestParam Long freezeId){
        balanceService.cancel(freezeId);
        return Response.ok();
    }
}
