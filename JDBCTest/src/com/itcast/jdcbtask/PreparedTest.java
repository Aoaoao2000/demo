package com.itcast.jdcbtask;

import java.io.IOException;
import java.sql.*;

/**
 * 使用PreparedStatement解决
 */
public class PreparedTest {

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db6", "root", "root");
            String sql = "select * from job where jname = ? and id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"懂事长");
            preparedStatement.setInt(2,1);
            //boolean execute = preparedStatement.execute();
            resultSet = preparedStatement.executeQuery();
            /**
             * 想要调用resultSet的方法，必须要调用next方法，指针才会过来
             */
            while(resultSet.next()){
                System.out.println(resultSet.getInt("id")+"......"+resultSet.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
