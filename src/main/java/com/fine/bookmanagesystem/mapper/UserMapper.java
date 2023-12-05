package com.fine.bookmanagesystem.mapper;

import com.fine.bookmanagesystem.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface UserMapper {

    // 创建用户
    void createUser(User user);

    // 根据用户名查询用户
    User getUserByUsername(@Param("username") String username);

    // 根据用户ID查询用户
    User getUserById(@Param("userId") Long userId);

    // 查询所有用户
    List<User> getAllUsers();

    // 查询特定角色的用户
    List<User> getUsersByRole(@Param("role") int role);

    // 更新用户信息
    void updateUser(User user);

    // 删除用户
    void deleteUser(@Param("userId") Long userId);

    // 根据用户名和密码验证用户登录
    User getUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}