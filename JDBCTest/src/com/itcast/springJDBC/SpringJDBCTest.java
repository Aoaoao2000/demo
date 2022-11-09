package com.itcast.springJDBC;

import com.itcast.ConectionPool.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * 练习SpringJDBC
 */
public class SpringJDBCTest {

    public static void main(String[] args) {
        //1.创建JdbcTemplate对象，这对象依赖数据库
        DataSource ds = JDBCUtils.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
        /**
         * 练习：
         * 		* 需求：
         * 			1. 修改1号数据的 salary 为 10000
         * 			2. 添加一条记录
         * 			3. 删除刚才添加的记录
         * 			4. 查询id为1的记录，将其封装为Map集合
         * 			5. 查询所有记录，将其封装为List
         * 			6. 查询所有记录，将其封装为Emp对象的List集合
         * 			7. 查询总记录数
         */
        //修改1号数据的 salary 为 10000
        /*String sql = "update emp set salary = 10000 where id = 1001";
        int i = jdbcTemplate.update(sql);
        System.out.println(i);*/
        //添加一条记录
        /*String sql = "insert into emp(id,ename,job_id) value(?,?,?)";
        int i = jdbcTemplate.update(sql,1015,"基尼太美2号",4);
        System.out.println(i);*/
        //3.删除刚才添加的记录
        /*String sql = "delete from emp where id = ?";
        int i = jdbcTemplate.update(sql,1015);
        System.out.println(i);*/
        //4. 查询id为1的记录，将其封装为Map集合,只能查一条数据
       /* String sql = "select * from emp where id = ?";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql,1001);
//        String sql = "select * from emp where id = ? or id = ?";
//        Map<String, Object> map = jdbcTemplate.queryForMap(sql,1001,1002);
        System.out.println(map);*/

        /*//5.查询所有记录，将其封装为List
        String sql = "select * from emp";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> emp : list){
            System.out.println(emp);
        }*/

        //6. 查询所有记录，将其封装为Emp对象的List集合
        /*String sql = "select * from dept";
        List<Dept> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<Dept>(Dept.class));
        for (Dept emp : list){
            System.out.println(emp);
        }*/

        //7. 查询总记录数
        String sql = "select count(id) from dept";
        Long count = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(count);
    }
}
