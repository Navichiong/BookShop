package com.nvc.bookshop.service.impl;

import com.nvc.bookshop.mapper.UserMapper;
import com.nvc.bookshop.pojo.User;
import com.nvc.bookshop.service.UserService;
import com.nvc.bookshop.utils.ServerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User handleGetUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    @Override
    public ServerMessage handleRegister(User user) {

        Integer integer = userMapper.addUser(user);
        if (integer > 0) {
            return ServerMessage.success();
        }
        return ServerMessage.error();
    }

    @Override
    public ServerMessage handleCheckUsername(String username) {
        ServerMessage sm = ServerMessage.getDefaultServerMessage();
        Long row = userMapper.countUserByUsername(username);
        if (row <= 0) {
            sm.setCode(100);
            sm.setMessage("用户名可用");
        } else {
            sm.setCode(200);
            sm.setMessage("用户已存在");
        }
        return sm;
    }

    @Override
    public ServerMessage handleLogin(User user) {

        ServerMessage sm = ServerMessage.getDefaultServerMessage();
        User u = userMapper.findUserByUsernameAndPassword(user);
        if (u == null) {
            sm.setCode(200);
            sm.setMessage("用户名或密码错误！");
        } else {
            u.setPassword(null);
            sm.addData("user", u);
            sm.setCode(100);
        }
        return sm;
    }
}
