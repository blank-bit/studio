package com.wang.service;

import com.wang.entity.User;
import com.wang.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2020-12-16 15:34:58
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User queryById(Integer id) {
        return userMapper.queryById(id);
    }

    public List<User> getAll(){
        return userMapper.getAll();
    }

    public int add(User user){
        return userMapper.add(user);
    }

    public int deleteById(int id){
        return userMapper.deleteById(id);
    }
}