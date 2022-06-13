package com.example.webdemo.service;

import com.example.webdemo.exception.DaoException;
import com.example.webdemo.exception.ServiceException;

public interface UserService {
    boolean authenticate(String login,String password) throws ServiceException, DaoException;
}
