package test.util.jdbc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;

/**
 * Created by lb on 2018/4/24.
 */
@Component
public class JdbcUtils {

    @Value(value = "${connection.driver}")
    private  String connection_driver = null;
    @Value(value = "${connection.url}")
    private  String connection_url = null;
    @Value(value = "${connection.username}")
    private  String connection_username = null;
    @Value(value = "${connection.password}")
    private  String connection_password = null;

    private JdbcUtils(){}

    private static JdbcUtils jdbcUtils = new JdbcUtils();
    public static  JdbcUtils getJdbcUtils(){
        return jdbcUtils;
    }

    public  Connection getConnection() throws SQLException {
        System.out.println("正在连接数据库：【驱动：" + getJdbcUtils().connection_driver + "，连接串：" + getJdbcUtils().connection_url + "，连接用户：" + getJdbcUtils().connection_username + "，连接密码：" + getJdbcUtils().connection_password + "】");
        return DriverManager.getConnection(getJdbcUtils().connection_url,getJdbcUtils().connection_username,getJdbcUtils().connection_password);
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
    }

}
