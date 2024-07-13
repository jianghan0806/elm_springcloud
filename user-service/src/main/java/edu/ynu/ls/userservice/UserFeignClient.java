package edu.ynu.ls.userservice;

import edu.ynu.ls.common.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-service")
public interface UserFeignClient {
    @PostMapping("/user/login")
    User login(@RequestParam(value = "userId") String userId, @RequestParam(value = "pwd") String pwd);
    @PostMapping("/user/register")
    int register(@RequestParam(value = "userId") String userId,@RequestParam(value = "password") String password,@RequestParam(value = "userName") String userName,@RequestParam(value = "userSex") int userSex);
    @GetMapping("/user/getUserInfo")
    int getUserInfo(@RequestParam(value = "userId") String userId);
}
