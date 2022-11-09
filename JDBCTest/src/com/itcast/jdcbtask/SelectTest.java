package com.itcast.jdcbtask;

import java.io.*;
import java.sql.*;

/**
 * 1. 游标向下移动一行
 * 2. 判断是否有数据
 * 3. 获取数据
 */
public class SelectTest {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        InputStream stream = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db6", "root", "root");
            statement = connection.createStatement();
            String sql = "select * from job";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int anInt = resultSet.getInt(1);
                stream = resultSet.getBinaryStream(2);
                byte[] bytes = stream.readAllBytes();
                String s = new String(bytes,"utf8");
                String description = resultSet.getString("description");

                System.out.println(anInt +"...."+s+"...."+description);
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (stream != null){
                try {
                    stream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(statement != null){
                try {
                    statement.close();
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
