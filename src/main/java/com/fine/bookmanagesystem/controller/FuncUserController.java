package com.fine.bookmanagesystem.controller;

import com.fine.bookmanagesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class FuncUserController {
    private final UserService userService;

    @Autowired
    public FuncUserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/{userId}/delete")
    public String deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
        return "redirect:/adminIndex#usersAll";
    }
}
