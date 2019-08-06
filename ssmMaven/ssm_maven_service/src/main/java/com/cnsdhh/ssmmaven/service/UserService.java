package com.cnsdhh.ssmmaven.service;

import com.cnsdhh.ssmmaven.pojo.User;

public interface UserService {

    // 根据username查询用户信息
    public User login(String username);

    // 添加登录用户信息
    public Integer register(User user);

}
