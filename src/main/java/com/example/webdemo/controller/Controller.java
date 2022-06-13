package com.example.webdemo.controller;

import java.io.*;

import com.example.webdemo.command.Command;
import com.example.webdemo.command.CommandType;
import com.example.webdemo.exception.CommandException;
import com.example.webdemo.pool.ConnectionPool;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet(name = "helloServlet", urlPatterns = "/controller")
public class Controller extends HttpServlet {
    static Logger logger = LogManager.getLogger();

    public void init() {
        ConnectionPool.getInstance();
        logger.log(Level.INFO,"---------->ServletInit" + this.getServletInfo());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");


        String commandStr = request.getParameter("command");
        Command command = CommandType.define(commandStr);
        String page = null;
        try {
            page = command.execute(request);
            request.getRequestDispatcher(page).forward(request,response);
//            response.sendRedirect("../"+page);
        } catch (CommandException e) {
//            response.sendError(500);//1
//            throw new ServletException(e);//2
            request.setAttribute("error_msg",e.getMessage());
            request.getRequestDispatcher("pages/error_500.jsp").forward(request, response);
        }


    }

    public void destroy() {
        ConnectionPool.getInstance().destroyPool();
        logger.log(Level.INFO,"---------->Servlet Destroyed" + this.getServletName());
    }
}