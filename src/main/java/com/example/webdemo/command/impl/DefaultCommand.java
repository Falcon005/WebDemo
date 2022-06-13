package com.example.webdemo.command.impl;

import com.example.webdemo.command.Command;
import jakarta.servlet.http.HttpServletRequest;

public class DefaultCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return "index.html";
    }
}
