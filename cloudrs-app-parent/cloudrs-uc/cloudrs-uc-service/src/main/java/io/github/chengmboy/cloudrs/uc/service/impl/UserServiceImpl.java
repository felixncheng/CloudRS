package io.github.chengmboy.cloudrs.uc.service.impl;

import java.security.GeneralSecurityException;

import io.github.chengmboy.cloudrs.uc.api.dto.UserDTO;
import io.github.chengmboy.cloudrs.uc.pojo.dto.UserRegisterDTO;
import io.github.chengmboy.cloudrs.uc.pojo.entity.User;
import io.github.chengmboy.cloudrs.uc.pojo.repository.UserRepository;
import io.github.chengmboy.cloudrs.uc.service.UserService;
import io.github.chengmboy.cloudrs.common.util.UserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author cheng_mboy
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public UserDTO register(UserRegisterDTO registerDTO) throws GeneralSecurityException {
        User user = new User();
        BeanUtils.copyProperties(registerDTO, user);
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        user.setPassword(encoder.encode(registerDTO.getPassword()));
        userRepository.save(user);
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    @Override
    public UserDTO getByLoginName(String loginName) {
        User user = userRepository.findByLoginName(loginName);
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    public static void main(String[] args) {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String encode = encoder.encode("123456");
        System.out.println(encode);
    }
}
