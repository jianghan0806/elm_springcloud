package edu.ynu.ls.userservice.impl;

import edu.ynu.ls.common.pojo.User;
import edu.ynu.ls.userservice.dao.IUserDao;
import edu.ynu.ls.userservice.service.IUserService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao iUserDao;

    @Override
    public User login(String userId, String pwd) {
        return iUserDao.findUserByUserIdAndPassword(userId, pwd);
    }

    @Override
    public int register(String userId, String password, String userName, int userSex) {
        User user = new User();
        user.setUserId(userId);
        user.setPassword(password);
        user.setUserName(userName);
        user.setUserSex(userSex);
        iUserDao.save(user);
        return 1;
    }

    @Override
    public int getUserInfo(String userId) {
        long count = iUserDao.countByUserId(userId);
        return (int) count;
    }
}
