package edu.ynu.ls.orderdetailetservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "edu.ynu.ls.orderdetailetservice.dao")
@EntityScan(basePackages = "edu.ynu.ls.common.pojo")
@EnableFeignClients(basePackages = "edu.ynu.ls.orderdetailetservice")  // Add this line
public class OrderdetailetServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderdetailetServiceApplication.class, args);
    }
}