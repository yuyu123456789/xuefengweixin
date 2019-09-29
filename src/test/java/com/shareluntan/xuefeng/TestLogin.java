package com.shareluntan.xuefeng;

import com.shareluntan.xuefeng.generator.User;
import com.shareluntan.xuefeng.generator.UserMapper;
import com.shareluntan.xuefeng.service.UserLoginServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestLogin {

    @Resource
    UserLoginServiceImpl service;

    @Resource
    UserMapper userMapper;

    @Test
    public void logintest() {

        int  id = 10000;
        boolean b = service.login(id,"123456");
        if(b) {
            System.out.println("success");
        }else {
            System.out.println("fail");
        }
    }
    @Test
    public void registertest() {
        User user = new User(new java.sql.Date(new Date().getTime()),"","123","456");
        userMapper.insert(user);
        Integer id = user.getId();
        System.out.println(id);
    }
}
