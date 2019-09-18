package io.github.chengmboy.cloudrs.ram.service;

import java.security.GeneralSecurityException;

import io.github.chengmboy.cloudrs.ram.pojo.dto.UserDTO;
import io.github.chengmboy.cloudrs.ram.pojo.dto.UserRegisterDTO;

/**
 * 用户服务
 * @author cheng_mboy
 */
public interface UserService {

    UserDTO register(UserRegisterDTO registerDTO) throws GeneralSecurityException;

}
