package io.github.chengmboy.cloudrs.auth.service;

import java.security.GeneralSecurityException;

import io.github.chengmboy.cloudrs.auth.api.dto.UserDTO;
import io.github.chengmboy.cloudrs.auth.pojo.dto.UserRegisterDTO;

/**
 * 用户服务
 * @author cheng_mboy
 */
public interface UserService {

    UserDTO register(UserRegisterDTO registerDTO) throws GeneralSecurityException;

    UserDTO getByLoginName(String loginName);
}
