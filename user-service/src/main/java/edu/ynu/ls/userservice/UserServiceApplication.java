package edu.ynu.ls.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;  // 导入此包
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"edu.ynu.ls.common.pojo"})
@EnableJpaRepositories(basePackages = {"edu.ynu.ls.userservice.dao"})
@EnableFeignClients(basePackages = {"edu.ynu.ls.userservice"})  // 添加此注解
public class UserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
