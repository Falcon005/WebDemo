package com.example.webdemo.command.impl;

import com.example.webdemo.command.Command;
import com.example.webdemo.exception.CommandException;
import com.example.webdemo.exception.DaoException;
import com.example.webdemo.exception.ServiceException;
import com.example.webdemo.service.UserService;
import com.example.webdemo.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException{
        String login = request.getParameter("login");
        String password = request.getParameter("pass");
        String page;
        UserService userService = UserServiceImpl.getInstance();
        HttpSession session = request.getSession();
        boolean match = false;
        try {
            match = userService.authenticate(login,password);
        } catch (ServiceException | DaoException e) {
            throw new CommandException(e);
        }
        if(match){
            request.setAttribute("user",login);

            session.setAttribute("userName",login);
            page = "pages/main.jsp";
        }
        else{
            request.setAttribute("Login_msg","incorrect login or password");
            page = "index.jsp";
        }
        session.setAttribute("current_page",page);
        return page;
    }
}
