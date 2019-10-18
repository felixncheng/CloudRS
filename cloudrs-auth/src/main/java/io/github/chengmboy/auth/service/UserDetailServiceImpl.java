package io.github.chengmboy.auth.service;


import io.github.chengmboy.auth.util.UserDetailsImpl;
import io.github.chengmboy.cloudrs.uc.api.UserRemoteService;
import io.github.chengmboy.cloudrs.uc.api.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service("userDetailService")
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRemoteService userRemoteService;

    @Override
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO user = userRemoteService.getByLoginName(username);
        return new UserDetailsImpl(user);
    }
}
