package io.github.chengmboy.cloudrs.ram.service.impl;

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
    public UserDTO register(UserRegisterDTO registerDTO) {
        User user = new User();
        BeanUtils.copyProperties(registerDTO, user);
        user.setId(1L);
        userRepository.save(user);
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }
}
