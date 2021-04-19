package com.tedu.mybatis;

import cn.tedu.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:Izaro
 * @Description:
 * @Date:Created in 16:58 2021/4/16
 * @Modified By:
 */
public class TestMybatis02 {
    SqlSession session = null;

    @Before
    public void beforeMethod() throws Exception {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession(true);
    }

    @Test
    public void testInsert() {
        int rows = session.insert("EmpMapper.insert");
        System.out.println("影响行数为:" + rows);
    }

    @Test
    public void testUpdate() {
        int rows = session.update("EmpMapper.update");
        System.out.println("影响行数为:" + rows);
    }

    @Test
    public void testDelete() {
        int rows = session.delete("EmpMapper.delete");
        System.out.println("影响行数为:" + rows);
    }

    @Test
    public void testInsert2() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "马云");
        map.put("job", "教师");
        map.put("salary", 800);
        int rows = session.insert("EmpMapper.insert2", map);
        System.out.println("影响行数为:" + rows);
    }

    @Test
    public void testUpdate2() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "马云");
        map.put("job", "CEO");
        map.put("salary", 10000000);
        session.update("EmpMapper.update2", map);
    }

    @Test
    public void testUpdate3() {
        //Emp emp=new Emp(null,"马云","教授",8888.8);
        Emp emp = new Emp();
        emp.setName("马云");
        emp.setJob("教授");
        emp.setSalary(8888.8);
        session.update("EmpMapper.update2", emp);
    }

    @Test
    public void testFindAll2() {
        Map<String, Object> map = new HashMap<>();
        map.put("colName", "id,name,job");
        List<Emp> list = session.selectList("EmpMapper.findAll2", "id,name,job");

        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    @Test
    public void testFindBySal() {
        Map map=new HashMap();
        map.put("minSal",3000);
        map.put("maxSal",4500);
        List<Emp> list = session.selectList("EmpMapper.findBySal",map);
        for (Emp emp :
                list) {
            System.out.println(emp);
        }
    }
}
