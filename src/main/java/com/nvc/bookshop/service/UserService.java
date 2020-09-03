package com.nvc.bookshop.service;

import com.nvc.bookshop.pojo.User;
import com.nvc.bookshop.utils.ServerMessage;

public interface UserService {

    User handleGetUserByUsername(String username);

    ServerMessage handleRegister(User user);

    ServerMessage handleCheckUsername(String username);

    ServerMessage handleLogin(User user);
}
