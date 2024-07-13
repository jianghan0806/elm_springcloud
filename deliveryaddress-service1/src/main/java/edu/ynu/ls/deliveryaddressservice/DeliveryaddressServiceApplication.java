package edu.ynu.ls.deliveryaddressservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.ynu.ls.deliveryaddressservice", "edu.ynu.ls.userservice", "edu.ynu.ls.common.pojo"})
@EnableJpaRepositories(basePackages = {"edu.ynu.ls.deliveryaddressservice.dao", "edu.ynu.ls.userservice.dao"})
@EntityScan(basePackages = "edu.ynu.ls.common.pojo")
@EnableFeignClients(basePackages = {"edu.ynu.ls.deliveryaddressservice", "edu.ynu.ls.userservice"})  // 确保包含 deliveryaddressservice 和 userservice 的包路径
public class DeliveryaddressServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeliveryaddressServiceApplication.class, args);
    }
}
