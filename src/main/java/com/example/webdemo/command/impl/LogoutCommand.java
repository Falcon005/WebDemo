package com.example.webdemo.command.impl;

import com.example.webdemo.command.Command;
import jakarta.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().invalidate();
        return "index.jsp";

    }
}
