package com.cnsdhh.ssmmaven.service.impl;

import com.cnsdhh.ssmmaven.mapper.UserDao;
import com.cnsdhh.ssmmaven.pojo.User;
import com.cnsdhh.ssmmaven.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
// 只是一个查询，用不用事务都行
//@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    // 根据username查询用户信息
    public User login(String username) {
        return userDao.login(username);
    }

    // 添加登录用户信息
    @Override
    public Integer register(User user) {
        return userDao.register(user);
    }

}
