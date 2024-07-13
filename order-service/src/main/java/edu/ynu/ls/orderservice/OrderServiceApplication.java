package edu.ynu.ls.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients(basePackages = {"edu.ynu.ls.orderservice"})
@EntityScan(basePackages = {"edu.ynu.ls.common.pojo"})
@EnableJpaRepositories(basePackages = {"edu.ynu.ls.orderservice.dao", "edu.ynu.ls.businessservice.dao", "edu.ynu.ls.cartservice", "edu.ynu.ls.deliveryaddressservice.dao", "edu.ynu.ls.userservice.dao"})  // 包含了 IUserDao 的包路径
@ComponentScan(basePackages = {"edu.ynu.ls.userservice.dao"})  // 添加了包扫描路径
public class OrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}
