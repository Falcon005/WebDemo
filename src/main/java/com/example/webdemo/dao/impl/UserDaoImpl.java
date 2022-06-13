package com.example.webdemo.dao.impl;

import com.example.webdemo.dao.BaseDao;
import com.example.webdemo.dao.UserDao;
import com.example.webdemo.entity.User;
import com.example.webdemo.exception.DaoException;
import com.example.webdemo.pool.ConnectionPool;

import java.sql.*;
import java.util.List;

public class UserDaoImpl extends BaseDao<User> implements UserDao {
    private final String SQL = "SELECT password FROM users WHERE name=?";
    private static UserDaoImpl instance = new UserDaoImpl();

    public static UserDaoImpl getInstance() {
        return instance;
    }

    private UserDaoImpl(){

    }
    @Override
    public boolean insert(User user) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public boolean authenticate(String login, String password) throws DaoException {
//        try{
//            DriverManager.registerDriver(new org.postgresql.Driver());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        String url = "jdbc:postgresql://localhost:5432/web1";
//        String user = "postgres";
//        String pass = "1404";
        ConnectionPool connectionPool = ConnectionPool.getInstance();


        boolean match = false;
        try(Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);) {

            preparedStatement.setString(1,login);
            ResultSet resultSet = preparedStatement.executeQuery();
            String passFromDb;
            if(resultSet.next()){
                passFromDb = resultSet.getString("password");
                match = password.equals(passFromDb);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return match;
    }
}
