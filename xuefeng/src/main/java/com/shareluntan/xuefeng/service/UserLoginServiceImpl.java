package com.shareluntan.xuefeng.service;


import com.shareluntan.xuefeng.generator.User;
import com.shareluntan.xuefeng.generator.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class UserLoginServiceImpl implements UserLoginService {


    @Resource
    UserMapper userMapper;

    @Override
    public boolean login(Integer id, String password) {
        User user = userMapper.selectByPrimaryKey(id);
        return user.getPassword().equals(password);
    }


    @Override
    public Integer register(String name, String password,String email) {
        User user = new User(new java.sql.Date(new Date().getTime()),email,password,name);
        userMapper.insert(user);
        return user.getId();
    }
}

