package com.wang.mapper;

import com.wang.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    User queryById(Integer id);
    List<User> getAll();
    int add(User user);
    int deleteById(int id);
}
