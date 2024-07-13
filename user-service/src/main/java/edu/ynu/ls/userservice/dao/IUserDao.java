package edu.ynu.ls.userservice.dao;

import edu.ynu.ls.common.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IUserDao extends JpaRepository<User, String> {
    @Transactional
    User findUserByUserId(String id);

    User findUserByUserIdAndPassword(String userId, String password);

    long countByUserId(String userId);
}

