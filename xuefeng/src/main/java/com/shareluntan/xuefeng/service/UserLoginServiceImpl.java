package com.shareluntan.xuefeng.service;


import com.shareluntan.xuefeng.generator.User;
import com.shareluntan.xuefeng.generator.UserMapper;
import com.shareluntan.xuefeng.model.UserVO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class UserLoginServiceImpl implements UserLoginService {


    @Resource
    UserMapper userMapper;

    @Autowired
    protected Mapper dozerMapper;

    @Override
    public boolean login(Integer id, String password) {
        User user = userMapper.selectByPrimaryKey(id);
        UserVO uservo = dozerMapper.map(user, UserVO.class);
        return uservo.getPassword().equals(password);
    }


    @Override
    public Integer register(String name, String password,String email) {
        User user = new User(new java.sql.Date(new Date().getTime()),email,password,name);
        userMapper.insert(user);
        return user.getId();
    }

   /* @Override
    public boolean deleteuser(Integer id, String password) {
        int i = userMapper.deleteByPrimaryKey(id);
        return false;
    }*/


}

