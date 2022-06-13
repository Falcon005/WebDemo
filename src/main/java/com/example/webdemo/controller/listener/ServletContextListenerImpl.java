package com.example.webdemo.controller.listener;

import com.example.webdemo.pool.ConnectionPool;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebListener
public class ServletContextListenerImpl implements ServletContextListener   {
    static Logger logger = LogManager.getLogger();

    public ServletContextListenerImpl() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        ConnectionPool.getInstance();
        logger.log(Level.INFO,"++++ contextInitialized :" +sce.getServletContext().getServerInfo());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
        logger.log(Level.INFO,"++++ contextDestroyed :" +sce.getServletContext().getContextPath());
        ConnectionPool.getInstance().destroyPool();
    }




}
