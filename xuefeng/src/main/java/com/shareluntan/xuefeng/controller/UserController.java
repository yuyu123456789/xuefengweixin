package com.shareluntan.xuefeng.controller;



import com.shareluntan.xuefeng.config.CustomException;
import com.shareluntan.xuefeng.config.CustomExceptionType;
import com.shareluntan.xuefeng.config.AjaxResponse;
import com.shareluntan.xuefeng.generator.User;
import com.shareluntan.xuefeng.service.UserLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
public class UserController {

    @Autowired
    UserLoginServiceImpl loginservice;

    @GetMapping("/login")
    public @ResponseBody AjaxResponse UserLogin(@RequestBody User user, HttpSession session) {
        System.out.println("用户登陆");
        Integer id = user.getId();
        String password = user.getPassword();
        if (!loginservice.login(id,password)) {
            return AjaxResponse.error(new CustomException(CustomExceptionType.USER_INPUT_ERROR, "您的账户或者密码错误"));
        }else {
            session.setAttribute("userId",id);
            session.setAttribute("password",password);
            return AjaxResponse.success();
            }


    }

    @GetMapping("/register")
    public String UserRegister(String name, String password,String email,Model model) {
        System.out.println("用户注册");
        if (name == null || password == null || name.equals("") || password.equals("")) {
            AjaxResponse error2 = AjaxResponse.error(new CustomException(CustomExceptionType.USER_INPUT_ERROR, "您的用户名或密码是null或者为空"));
            model.addAttribute("code", error2.getCode());
            model.addAttribute("message", error2.getMessage());
            return "fail.html";
        }else {
            Integer register = loginservice.register(name, password, email);
            System.out.println(register);
            model.addAttribute("id", "你的账号是"+register);
            return "success.html";
        }


    }


}
