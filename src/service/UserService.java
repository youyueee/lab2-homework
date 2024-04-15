package service;

import bean.entity.User;

import java.util.Optional;

public interface UserService {
    public Optional<String> validate(String name, String password); // 验证成功返回用户ID
    public Optional<String> register(User u); //返回用户ID
}

