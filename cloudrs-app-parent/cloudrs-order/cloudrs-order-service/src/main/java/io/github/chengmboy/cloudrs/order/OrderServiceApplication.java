package io.github.chengmboy.cloudrs.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@EnableFeignClients(basePackages = {"io.github.chengmboy.cloudrs"})
@EnableSwagger2
@EnableHystrix
@SpringBootApplication(scanBasePackages = {"io.github.chengmboy.cloudrs"})
//@EnableApolloConfig
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}
}
