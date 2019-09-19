package io.github.chengmboy.cloudrs.common.config;

import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author cheng_mboy
 */
@Configuration
@EnableJpaAuditing
@Slf4j
public class AuditorAwareConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        log.info(">>> auditorProvider ");
        return new SpringSecurityAuditorAware();
    }

    private class SpringSecurityAuditorAware implements AuditorAware<String> {

        @Override
        public Optional<String> getCurrentAuditor() {
            //用户信息 后期接入spring security
            return Optional.of("chengmboy");
        }
    }
}
