package io.github.chengmboy.cloudrs.ram.service.impl;

import java.security.GeneralSecurityException;

import io.github.chengmboy.cloudrs.common.util.common.security.PasswordUtil;
import io.github.chengmboy.cloudrs.ram.pojo.dto.UserDTO;
import io.github.chengmboy.cloudrs.ram.pojo.dto.UserRegisterDTO;
import io.github.chengmboy.cloudrs.ram.pojo.entity.User;
import io.github.chengmboy.cloudrs.ram.pojo.repository.UserRepository;
import io.github.chengmboy.cloudrs.ram.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
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
        user.setId(1L);

        PasswordUtil.Password password = PasswordUtil.generate(registerDTO.getPassword());
        user.setSalt(password.getSalt());
        user.setPassword(password.getPassword());
        userRepository.save(user);
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }
}
