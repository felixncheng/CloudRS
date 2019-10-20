package io.github.chengmboy.auth.service;


import io.github.chengmboy.auth.util.UserDetailsImpl;
import io.github.chengmboy.cloudrs.uc.api.UcRemoteService;
import io.github.chengmboy.cloudrs.uc.api.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service("userDetailService")
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UcRemoteService ucRemoteService;

    @Override
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO user = ucRemoteService.getByLoginName(username);
        return new UserDetailsImpl(user);
    }
}
