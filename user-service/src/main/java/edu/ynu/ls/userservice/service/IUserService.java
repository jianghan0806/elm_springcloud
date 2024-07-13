package edu.ynu.ls.userservice.service;

import edu.ynu.ls.common.pojo.User;

public interface IUserService {
    User login(String userId, String pwd); // Updated to return User
    int register(String userId, String password, String userName, int userSex);
    int getUserInfo(String userId);
}
