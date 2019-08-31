package io.github.chengmboy.cloudrs.ram.controller;

import com.alibaba.fastjson.JSONObject;
import io.github.chengmboy.cloudrs.common.web.Response;
import io.github.chengmboy.cloudrs.ram.pojo.dto.UserDTO;
import io.github.chengmboy.cloudrs.ram.pojo.dto.UserRegisterDTO;
import io.github.chengmboy.cloudrs.ram.pojo.vo.UserVO;
import io.github.chengmboy.cloudrs.ram.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * 用户控制器
 * @author cheng_mboy
 */
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;
    @PostMapping
    public Response<UserVO> register(@RequestBody UserRegisterDTO user) {
        log.info(JSONObject.toJSONString(user));
        UserDTO userDTO = userService.register(user);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userDTO,userVO);
        return Response.ok(userVO);
    }
}
