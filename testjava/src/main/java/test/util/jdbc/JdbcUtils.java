package test.util.jdbc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by lb on 2018/4/24. jdbcutils 获取jdbc链接
 */
public class JdbcUtils {

    private static String connection_driver;
    private static String connection_url;
    private static String connection_username;
    private static String connection_password;

    static {
        try {

            InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("resources.properties");
            Properties prop = new Properties();
            prop.load(is);

            connection_driver = prop.getProperty("connection.driver");
            connection_url = prop.getProperty("connection.url");
            connection_username = prop.getProperty("connection.username");
            connection_password = prop.getProperty("connection.password");

        }catch (Exception var1){
            var1.printStackTrace();
        }
    }

    public  static  Connection getConnection() throws SQLException {
        System.out.println("正在连接数据库：【驱动：" + connection_driver + "，连接串：" + connection_url + "，连接用户：" + connection_username + "，连接密码：" + connection_password + "】");
        return DriverManager.getConnection(connection_url,connection_username,connection_password);
    }

    public  static void release(Connection connection, Statement statement, ResultSet rs){
        System.out.println("正在释放数据库连接资源...");
        try {
            if(rs !=null){
                rs.close();
            }
            if(statement !=null){
                statement.close();
            }
            if(connection !=null){
                connection.close();
            }
        }catch (SQLException var1){
            var1.printStackTrace();
        }
        System.out.println("释放成功...");

    }

}
