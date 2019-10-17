package io.github.chengmboy.cloudrs.uc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@EnableFeignClients
@EnableSwagger2
@SpringBootApplication(scanBasePackages = {"io.github.chengmboy.cloudrs.uc","io.github.chengmboy.cloudrs.common.bean"})
public class UcServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UcServiceApplication.class, args);
	}
}
