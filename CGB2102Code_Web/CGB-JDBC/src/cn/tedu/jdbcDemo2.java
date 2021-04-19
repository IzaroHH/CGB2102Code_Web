package cn.tedu;

import org.junit.Test;

import java.sql.*;

/**
 * @Author:Izaro
 * @Description:
 * @Date:Created in 14:31 2021/4/14
 * @Modified By:
 */
public class jdbcDemo2 {

    /**
     * 新增表记录:往account表中添加一条记录:null 'hellen' 3500
     */
    @Test
    public void testAdd() throws Exception {
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取连接
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql:///jt_db?characterEncoding=utf-8&serverTimezone=Asia/Shanghai", "root", "666999"
        );
        //获取传输器
        Statement stat = conn.createStatement();
        //执行SQL语句,返回执行结果
        String sql = "insert into account value(null,'hellen',3500)";
        int rows = stat.executeUpdate(sql);
        //处理结果
        System.out.println("影响行数:" + rows);
        //释放资源
        stat.close();
        conn.close();
    }

    @Test
    public void testUpdate() {
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            Connection conn = DriverManager.getConnection("jdbc:mysql:///jt_db?characterEncoding=utf-8&serverTimezone=Asia/Shanghai", "root", "666999"
            );
            //获取传输器
            Statement stat = conn.createStatement();
            String sql = "update account set money=1500 where name='hellen'";
            int rows = stat.executeUpdate(sql);
            System.out.println("影响行数:" + rows);
            stat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelete() {
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            Connection conn = DriverManager.getConnection("jdbc:mysql:///jt_db?characterEncoding=utf-8&serverTimezone=Asia/Shanghai", "root", "666999"
            );
            //获取传输器
            Statement stat = conn.createStatement();
            String sql = "delete from account where name='hellen'";
            int rows = stat.executeUpdate(sql);
            System.out.println("影响行数:" + rows);
            stat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

