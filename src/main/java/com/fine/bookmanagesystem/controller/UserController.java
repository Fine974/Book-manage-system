package com.fine.bookmanagesystem.controller;

import com.fine.bookmanagesystem.model.User;
import com.fine.bookmanagesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("role") int role) {

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);

        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/username/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/role/{role}")
    public List<User> getUsersByRole(@PathVariable int role) {
        return userService.getUsersByRole(role);
    }

    @PostMapping("/update")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @PostMapping("/delete/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestParam String username, @RequestParam String password) {
        User user = userService.getUserByUsernameAndPassword(username, password);
        if (user != null) {
            // 登录成功
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            // 登录失败
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}