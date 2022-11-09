package com.itcast.ConectionPool;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 练习阿里巴巴的Druid数据库
 */
public class DruidPool {
    public static void main(String[] args) {
        //1加载配置文件
        Properties pro = new Properties();
        InputStream stream = null;
        Connection connection = null;
        try {
            stream= DruidPool.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(stream);
            //2.获取连接池对象
            DataSource dataSource = dataSource = DruidDataSourceFactory.createDataSource(pro);
            connection = dataSource.getConnection();
            //3.获得数据库里面的内容
            String sql = "select * from job";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1)+"...."+resultSet.getString(3));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            //归还链接
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (stream != null){
                try {
                    stream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
