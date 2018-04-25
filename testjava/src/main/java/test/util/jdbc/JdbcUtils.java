package test.util.jdbc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;

/**
 * Created by lb on 2018/4/24.
 */
@Component
public class JdbcUtils {

    @Value("${connection.driver}")
    public  String connection_driver;
    @Value("${connection.url}")
    public  String connection_url;
    @Value("${connection.username}")
    public  String connection_username;
    @Value("${connection.password}")
    public  String connection_password;

    public  Connection getConnection() throws SQLException {
        System.out.println("正在连接数据库：【驱动：" + connection_driver + "，连接串：" + connection_url + "，连接用户：" + connection_username + "，连接密码：" + connection_password + "】");
        return DriverManager.getConnection(connection_url,connection_username,connection_password);
    }

    public  void release(Connection connection, Statement statement, ResultSet rs){
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
