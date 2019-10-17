package io.github.chengmboy.auth.service;


import io.github.chengmboy.auth.util.UserDetailsImpl;
import io.github.chengmboy.cloudrs.uc.api.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailsService {


    @Override
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(123L);
        userDTO.setName("chengmboy");
        userDTO.setPassword("{bcrypt}$2a$10$YCnmdlVnNsXdxR8t7glNeO5lPlDpbEijuFHrkcT13KcbqXsEVUqAC");
        return new UserDetailsImpl(userDTO);
    }
}
