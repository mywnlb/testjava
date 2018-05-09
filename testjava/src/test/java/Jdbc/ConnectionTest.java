package Jdbc;

import org.junit.Test;
import test.util.jdbc.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lb on 2018/4/24. 测试jdbc链接
 */
public class ConnectionTest {
    Connection connection = null;

    PreparedStatement preparedStatement = null;

    ResultSet resultSet = null;

    boolean defaultCommit = true;

    StringBuilder sb = new StringBuilder();

    @Test
    public void testJdbc(){
        try {
            connection = JdbcUtils.getConnection();

            //得到数据库事物处理的默认提交方式
            defaultCommit = connection.getAutoCommit();

            //1 开启事物，不自动提交
            connection.setAutoCommit(false);

            String sql = "SELECT * FROM upms_user";

            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                sb.append(resultSet.getString("username"));
            }

            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();

            try {
                if(connection !=null){
                    connection.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {

            try {
                if(connection !=null){
                    connection.setAutoCommit(defaultCommit);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            //关闭链接
            JdbcUtils.release(connection,preparedStatement,resultSet);
        }

        System.out.println(sb);
    }
}
