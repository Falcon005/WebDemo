package com.example.webdemo.dao;

import com.example.webdemo.exception.DaoException;

public interface UserDao {
    boolean authenticate(String login,String password) throws DaoException;
}
