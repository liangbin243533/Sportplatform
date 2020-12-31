package com.chen.sportplatform.dao;

import com.chen.sportplatform.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    public User getUserByMessage(@Param("username") String username, @Param("password") String password);
}
