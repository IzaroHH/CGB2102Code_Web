package cn.tedu.dao;

import cn.tedu.pojo.Emp;

import java.util.List;

/**
 * @Author:Izaro
 * @Description:
 * @Date:Created in 18:13 2021/4/19
 * @Modified By:
 */
public interface EmpMapper {
    /**
     * 01:查询emp表中的所有员工信息
     *
     * @return
     */
    List<Emp> findAll();
}

