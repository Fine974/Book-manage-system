package com.fine.bookmanagesystem.service.impl;

import com.fine.bookmanagesystem.mapper.UserMapper;
import com.fine.bookmanagesystem.model.Product;
import com.fine.bookmanagesystem.model.User;
import com.fine.bookmanagesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void createUser(User user) {
        userMapper.createUser(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    @Override
    public User getUserById(Long userId) {
        return userMapper.getUserById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userMapper.getAllUsers();
        System.out.println("Number of users retrieved: " + users.size());
        return users;
    }

    @Override
    public List<User> getUsersByRole(int role) {
        return userMapper.getUsersByRole(role);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        userMapper.deleteUser(userId);
    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        return userMapper.getUserByUsernameAndPassword(username, password);
    }
}