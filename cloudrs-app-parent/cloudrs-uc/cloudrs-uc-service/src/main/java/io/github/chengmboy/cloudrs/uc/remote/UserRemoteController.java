package io.github.chengmboy.cloudrs.uc.remote;

import io.github.chengmboy.cloudrs.uc.service.UserService;
import io.github.chengmboy.cloudrs.uc.api.UserRemoteService;
import io.github.chengmboy.cloudrs.uc.api.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cheng_mboy
 */
@RestController
@RequiredArgsConstructor
public class UserRemoteController implements UserRemoteService {

    final UserService userService;

    @Override
    public UserDTO getByLoginName(@PathVariable("loginName") String loginName) {
        return userService.getByLoginName(loginName);
    }
}
