package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * JDBC的快速入门程序
 * <p>
 * 查询jt_db库中account表中的所有记录
 * <p>
 * select * from account;
 *
 * @Author:Izaro
 * @Description:
 * @Date:Created in 11:14 2021/4/14
 * @Modified By:
 */
public class jdbcDemo1 {
    public static void main(String[] args) throws Exception {
        //1.注册数据库驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取数据库连接
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jt_db?characterEncoding=utf-8&serverTimezone=Asia/Shanghai", "root", "666999");
        //3.获取传输器
        Statement stat = conn.createStatement();
        //4.发送sql到数据库执行,并返回执行结果
        String sql = "select * from account";
        ResultSet rs = stat.executeQuery(sql);
        System.out.println(rs);
        //5.处理结果(打印到控制台)
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double money = rs.getDouble("money");
            System.out.println(id + ":" + name + ":" + money);
        }
        //6.释放资源
        rs.close();
        stat.close();
        conn.close();
        System.out.println("TestJdbbc.main()...");
    }
}
