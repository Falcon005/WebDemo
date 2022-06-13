package com.example.webdemo.service.impl;

import com.example.webdemo.dao.impl.UserDaoImpl;
import com.example.webdemo.exception.DaoException;
import com.example.webdemo.service.UserService;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl instance = new UserServiceImpl();
    private UserServiceImpl(){

    }

    public static UserServiceImpl getInstance() {
        return instance;
    }

    @Override
    public boolean authenticate(String login, String password) throws DaoException {
        //validate login,pass + md5
        UserDaoImpl userDao=UserDaoImpl.getInstance();
        return userDao.authenticate(login,password);
    }
}
