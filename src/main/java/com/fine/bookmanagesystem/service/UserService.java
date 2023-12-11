package com.fine.bookmanagesystem.service;

import com.fine.bookmanagesystem.model.User;

import java.util.List;

public interface UserService {

    void createUser(User user);

    User getUserByUsername(String username);

    User getUserById(Long userId);

    List<User> getAllUsers();

    List<User> getUsersByRole(int role);

    void updateUser(User user);

    void deleteUser(Integer userId);

    User getUserByUsernameAndPassword(String username, String password);
}