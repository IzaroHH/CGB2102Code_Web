package cn.tedu.mybatis;

import cn.tedu.dao.EmpMapper;
import cn.tedu.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @Author:Izaro
 * @Description:
 * @Date:Created in 16:58 2021/4/16
 * @Modified By:
 */
public class Mybatis03Test {
    SqlSession session = null;

    @Before
    public void beforeMethod() throws Exception {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession(true);
    }

    @Test
    public void testFindAll() {
        EmpMapper mapper = session.getMapper(EmpMapper.class);
        List<Emp> list = mapper.findAll();
        for (Emp emp :
                list) {
            System.out.println(emp);
        }

    }
}