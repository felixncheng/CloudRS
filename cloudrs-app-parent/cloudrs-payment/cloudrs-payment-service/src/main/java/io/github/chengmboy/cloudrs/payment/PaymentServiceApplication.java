package io.github.chengmboy.cloudrs.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@EnableFeignClients(basePackages = {"io.github.chengmboy.cloudrs"})
@EnableSwagger2
@SpringBootApplication(scanBasePackages = {"io.github.chengmboy.cloudrs.payment","io.github.chengmboy.cloudrs.common.bean"})
public class PaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceApplication.class, args);
	}
}