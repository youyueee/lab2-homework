package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
/**
 *
 * 面向数据库连接的工具类。
 *
 * @author xmwang
 *
 */
public class JDBCConnector {
    public static Connection getConnection() {
        Connection c = null;
        InputStream is = JDBCConnector.class.getResourceAsStream("ds.properties");
        Properties p = new Properties();
        try {
            p.load(is);
            try(BasicDataSource bds = BasicDataSourceFactory.createDataSource(p)){
                c = bds.getConnection();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return c;
    }
}