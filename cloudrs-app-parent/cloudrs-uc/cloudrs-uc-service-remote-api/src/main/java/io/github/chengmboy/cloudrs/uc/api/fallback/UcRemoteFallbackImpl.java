package io.github.chengmboy.cloudrs.uc.api.fallback;

import io.github.chengmboy.cloudrs.uc.api.UcRemoteService;
import io.github.chengmboy.cloudrs.uc.api.dto.PermissionDTO;
import io.github.chengmboy.cloudrs.uc.api.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
public class UcRemoteFallbackImpl implements UcRemoteService {


    @Override
    public Set<PermissionDTO> findPermissionByRoleCode(String roleCode) {
        log.error("调用{}异常:{}", "findPermissionByRoleCode", roleCode);
        return null;
    }

    @Override
    public UserDTO getByLoginName(String loginName) {
        log.error("调用{}异常:{}", "getByLoginName", loginName);
        return null;
    }

    @Override
    public void deduct(String code, int count) {
        log.error("调用{}异常:{}", "deduct", code);
    }


}
