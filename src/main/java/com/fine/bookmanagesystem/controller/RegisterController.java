package com.fine.bookmanagesystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {
    @RequestMapping("/registerPage")
    public String register() {
        return "register";
    }
}
