package com.example.webdemo.command;

import com.example.webdemo.exception.CommandException;
import com.example.webdemo.exception.DaoException;
import com.example.webdemo.exception.ServiceException;
import jakarta.servlet.http.HttpServletRequest;

@FunctionalInterface
public interface Command {
    String execute(HttpServletRequest request) throws CommandException;
    default void refresh(){}
}
