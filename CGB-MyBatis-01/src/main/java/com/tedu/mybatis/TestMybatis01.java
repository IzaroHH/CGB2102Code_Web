package com.tedu.mybatis;


import cn.tedu.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * 练习1:查询emp表中的所有员工,返回一个List<Emp>集合
 *
 * @Author:Izaro
 * @Description:
 * @Date:Created in 9:37 2021/4/16
 * @Modified By:
 */
public class TestMybatis01 {
    public static void main(String[] args) throws Exception {
        //1.读取mybatis的核心配置文件(mybatis-config.xml)
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        //2.通过配置信息获取一个SqlSessionFactory工厂对象
        SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(in);
        //3.通过工厂获取一个SqlSession对象
        SqlSession session = fac.openSession();
        //4.通过namespace+id找到要执行的sql语句并执行sql语句
        //EmpMapper.xml,List<Emp>
        List<Emp> list = session.selectList("EmpMapper.findAll");
        //5.输出结果
        for(Emp emp:list){
            System.out.println(emp);
        }
    }
}
