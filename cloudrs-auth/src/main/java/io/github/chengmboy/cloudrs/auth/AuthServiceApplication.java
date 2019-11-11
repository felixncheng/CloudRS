package io.github.chengmboy.cloudrs.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@EnableFeignClients(basePackages = "io.github.chengmboy.cloudrs.*.api")
@SpringBootApplication(scanBasePackages = {"io.github.chengmboy.cloudrs.auth","io.github.chengmboy.cloudrs.*.api",
		"io.github.chengmboy.cloudrs.common.bean"})
@EnableHystrix
@EnableSwagger2
public class AuthServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}
}
