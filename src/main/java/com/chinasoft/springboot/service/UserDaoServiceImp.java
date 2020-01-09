package com.chinasoft.springboot.service;

import com.chinasoft.springboot.dao.UserDao;
import com.chinasoft.springboot.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDaoServiceImp implements UserDaoService {
    @Autowired
    private UserDao userDao;
    @Override
    public User findByUserName(String userName) {
        User user = userDao.findByUserName(userName);
        return user;
    }
}
