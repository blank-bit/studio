package com.wang.Dao;

import com.wang.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-19 16:09:44
 */
public interface IUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Integer id);

    /**
     * 查询所有
     *
     * @param
     * @return 对象列表
     */
    List<User> queryAll();

}