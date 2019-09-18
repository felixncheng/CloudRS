package io.github.chengmboy.cloudrs.common.component;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

/**
 * @author cheng_mboy
 */
@Component
public class SpringSecurityAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        //用户信息 后期接入spring security
        return Optional.of("chengmboy");
    }
}
