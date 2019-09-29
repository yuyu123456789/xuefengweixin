package com.shareluntan.xuefeng.service;

public interface UserLoginService {
    boolean login(Integer id, String password);
    Integer register(String name, String password, String email);
//    boolean deleteuser(Integer id,String password);
}
