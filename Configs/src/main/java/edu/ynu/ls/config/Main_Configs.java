package edu.ynu.ls.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Main_Configs {
    public static void main(String[] args) {
        SpringApplication.run(Main_Configs.class,args);
    }
}