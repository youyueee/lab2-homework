package dao.impl;

import bean.entity.User;
import dao.UserDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import utils.JDBCConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

    private static final Log log = LogFactory.getLog(UserDaoImpl.class);

    @Override
    public String create(User u) {
        try(Connection conn = JDBCConnector.getConnection()){
            // 创建用户
            PreparedStatement pstmt = conn.prepareStatement("insert into user values(?,?,?,?)");
            pstmt.setString(1, u.getUid());
            pstmt.setString(2, u.getName());
            pstmt.setString(3, u.getPassword());
            pstmt.setString(4, u.getEmail());
            pstmt.executeUpdate();
            return u.getUid();
        } catch (SQLException e) {
            log.warn("创建用户[" + u.getName() + "]失败");
        }
        return null;
    }

    @Override
    public User read(String id) {
        return null;
    }

    @Override
    public void update(User transientObject) {

    }

    @Override
    public void delete(User persistentObject) {

    }

    @Override
    public Optional<User> findByName(String userName) {
        Optional<User> u = Optional.empty();
        try(Connection conn = JDBCConnector.getConnection()){
            PreparedStatement pstmt = conn.prepareStatement("select * from user where name = ?");
            pstmt.setString(1, userName);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                User tempu = new User(rs.getString("uid"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getString("email"));
                u = Optional.of(tempu);
            }
        } catch (SQLException e) {
            log.warn("基于名称["+ userName +"]查找用户失败");
        }
        return u;
    }

}

