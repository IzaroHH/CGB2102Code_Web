package cn.tedu;

import cn.tedu.pojo.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Izaro
 * @Description:
 * @Date:Created in 17:12 2021/4/15
 * @Modified By:
 */
public class JdbcTest {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql:///yonghedb?characterEncoding=utf-8&serverTimezone=Asia/Shanghai", "root", "666999"
            );
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("select * from emp");
            List<Emp> list = new ArrayList<Emp>();
            Emp emp;
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String job = rs.getString("job");
                double salary = rs.getDouble("salary");
                emp = new Emp();
                emp.setId(id);
                emp.setName(name);
                emp.setJob(job);
                emp.setSalary(salary);
                list.add(emp);
            }

            for (Emp e : list) {
                System.out.println(e);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
