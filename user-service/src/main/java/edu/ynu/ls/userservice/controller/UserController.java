package edu.ynu.ls.userservice.controller;

import edu.ynu.ls.userservice.UserFeignClient;
import edu.ynu.ls.userservice.util.JwtTokenUtil;
import jakarta.annotation.Resource;/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;*/
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserFeignClient userFeignClient;
    @Resource
    JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    String login(@RequestParam(value = "userId") String userId, @RequestParam(value = "pwd") String pwd){
        return userFeignClient.login(userId,pwd)!=null? jwtTokenUtil.generateToken(userId) :null;
    }

    @PostMapping("/register")
    int register(@RequestParam(value = "userId") String userId,@RequestParam(value = "password") String password,@RequestParam(value = "userName") String userName,@RequestParam(value = "userSex") int userSex){
        return userFeignClient.register(userId,password,userName,userSex);
    }

    @GetMapping("/getUserInfo")//得到用户信息
    int getUserInfo(@RequestParam(value = "userId") String userId){
        return userFeignClient.getUserInfo(userId);
    }

}

