package com.nvc.bookshop.mapper;

import com.nvc.bookshop.pojo.User;

public interface UserMapper {

    User findUserByUsername(String username);

    Integer addUser(User user);

    Long countUserByUsername(String username);

    User findUserByUsernameAndPassword(User user);

    User findUserById(Integer id);

}
