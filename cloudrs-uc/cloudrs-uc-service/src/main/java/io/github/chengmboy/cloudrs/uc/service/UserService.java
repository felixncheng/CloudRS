package io.github.chengmboy.cloudrs.uc.service;

import java.security.GeneralSecurityException;

import io.github.chengmboy.cloudrs.uc.api.dto.UserDTO;
import io.github.chengmboy.cloudrs.uc.pojo.dto.UserRegisterDTO;

/**
 * 用户服务
 * @author cheng_mboy
 */
public interface UserService {

    UserDTO register(UserRegisterDTO registerDTO) throws GeneralSecurityException;

    UserDTO getByLoginName(String loginName);
}
