package com.jerry.springboot_pagehelper.service.impl;

import com.jerry.springboot_pagehelper.dao.BaseDao;
import com.jerry.springboot_pagehelper.dao.master.UserDao;
import com.jerry.springboot_pagehelper.pojo.User;
import com.jerry.springboot_pagehelper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    protected BaseDao<User> getMapper() {
        return this.userDao;
    }
}
