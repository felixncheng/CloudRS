package io.github.chengmboy.cloudrs;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableZuulProxy
@EnableFeignClients(basePackages = {"io.github.chengmboy.cloudrs"})
@EnableEurekaClient
@EnableHystrix
@SpringBootApplication(scanBasePackages = {"io.github.chengmboy.cloudrs"})
@EnableSwagger2
//@EnableApolloConfig
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
}
