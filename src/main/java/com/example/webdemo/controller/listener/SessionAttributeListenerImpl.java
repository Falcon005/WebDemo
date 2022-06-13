package com.example.webdemo.controller.listener;

import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SessionAttributeListenerImpl implements HttpSessionAttributeListener {
    static Logger logger = LogManager.getLogger();
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        logger.log(Level.INFO,"++++<<<<--------> attributeAdded :" +event.getSession().getAttribute("userName"));
        logger.log(Level.INFO,"++++<<<<--------> attributeAdded :" +event.getSession().getAttribute("current_page"));
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        logger.log(Level.INFO,"####--------> attributeReplaced :" +event.getSession().getAttribute("userName"));
        logger.log(Level.INFO,"####--------> attributeReplaced :" +event.getSession().getAttribute("userName"));
    }
}
