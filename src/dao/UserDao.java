package dao;

import bean.entity.User;

import java.util.Optional;

public interface UserDao extends Dao<User, String> {
    Optional<User> findByName(String userName); // 根据名字查找用户，用户名为唯一值，返回结果唯一
}