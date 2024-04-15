package service.impl;

import bean.entity.User;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import service.UserService;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    private UserDao ud = new UserDaoImpl();

    @Override
    public Optional<String> validate(String name, String password) {
        Optional<String> uid = Optional.empty();
        Optional<User> u = ud.findByName(name);
        if(u.isPresent()) {
            if(u.get().getPassword().equals(password)) {
                uid = Optional.of(u.get().getUid());
            }
        }
        return uid;
    }

    @Override
    public Optional<String> register(User u) {
        // 返回的主键可能为空，表示注册失败
        Optional<String> id = Optional.ofNullable(ud.create(u));
        return id;
    }

}
