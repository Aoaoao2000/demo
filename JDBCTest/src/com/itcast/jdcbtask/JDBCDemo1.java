package com.itcast.jdcbtask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *             1. account表 添加一条记录
 *             2. account表 修改记录
 *             3. account表 删除一条记录
 */
public class JDBCDemo1 {
    public static void main(String[] args) {
        try {
            //抛出类找不到的异常，注册数据库驱动
            //Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");     //注意：mysql5之后的驱动jar包可以省略注册驱动的步骤
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db6", "root", "root");
            //获得执行sql的对象
            Statement statement = connection.createStatement();
            /*String sql = "update emp set ename = '基尼太美' where id = 1014";
            //执行sql语句
            int i = statement.executeUpdate(sql);
            System.out.println(i);
            System.out.println(connection);*/
            //释放资源
            //String sql = "INSERT INTO job(id,jname,description) VALUE(5,'程序员','开发人员')";
            //String sql = "update job set jname = '懂事长' where id = 1";
            String sql = "delete from job where id = 5";
            int i = statement.executeUpdate(sql);
            System.out.println(i);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
