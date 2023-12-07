package com.fine.bookmanagesystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    @RequestMapping("/adminIndex")
    public String login() {
        return "adminIndex";
    }
}
