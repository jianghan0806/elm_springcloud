package edu.ynu.ls.businessservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"edu.ynu.ls.common.pojo"})
@EnableJpaRepositories(basePackages = {"edu.ynu.ls.businessservice.dao"})
@EnableFeignClients(basePackages = {"edu.ynu.ls.businessservice"})
public class BusinessServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(BusinessServiceApplication.class, args);
	}
}
