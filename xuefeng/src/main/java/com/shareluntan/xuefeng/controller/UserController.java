package com.shareluntan.xuefeng.controller;



import com.shareluntan.xuefeng.config.CustomException;
import com.shareluntan.xuefeng.config.CustomExceptionType;
import com.shareluntan.xuefeng.config.ResponseClass;
import com.shareluntan.xuefeng.service.UserLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class UserController {

    @Autowired
    UserLoginServiceImpl loginservice;

    @GetMapping("/login")
    public String UserLogin(Integer id, String password, Model model, HttpSession session) {
        System.out.println("用户登陆");
        if (id == null || password == null || id.equals("") || password.equals("")) {
            ResponseClass error1 = ResponseClass.error(new CustomException(CustomExceptionType.USER_INPUT_ERROR, "您的账号或密码是null或者为空"));
            model.addAttribute("code", error1.getCode());
            model.addAttribute("message", error1.getMessage());
            return "fail.html";
        }
        boolean login = loginservice.login(id, password);

        if (!login) {
            ResponseClass error1 = ResponseClass.error(new CustomException(CustomExceptionType.USER_INPUT_ERROR, "您的账户或者密码错误"));
            model.addAttribute("code", error1.getCode());
            model.addAttribute("message", error1.getMessage());
            return "fail.html";
        }else {
            session.setAttribute("userId", id);
            session.setAttribute("password", password);
            return "action.html";
            }


    }

    @GetMapping("/register")
    public String UserRegister(String name, String password,String email,Model model) {
        System.out.println("用户注册");
        if (name == null || password == null || name.equals("") || password.equals("")) {
            ResponseClass error2 = ResponseClass.error(new CustomException(CustomExceptionType.USER_INPUT_ERROR, "您的用户名或密码是null或者为空"));
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
