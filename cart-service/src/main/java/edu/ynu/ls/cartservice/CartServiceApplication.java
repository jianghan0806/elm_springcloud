package edu.ynu.ls.cartservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableFeignClients(basePackages = "edu.ynu.ls")
@EnableJpaRepositories(basePackages = "edu.ynu.ls.cartservice.dao")
@ComponentScan(basePackages = "edu.ynu.ls")
@EntityScan(basePackages = "edu.ynu.ls.common.pojo")
public class CartServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CartServiceApplication.class, args);
    }
}
