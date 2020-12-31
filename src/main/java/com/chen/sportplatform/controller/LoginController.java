package com.chen.sportplatform.controller;

import com.alibaba.fastjson.JSON;
import com.chen.sportplatform.dao.UserDao;
import com.chen.sportplatform.entity.User;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class LoginController {

    @Autowired
    UserDao userDao;

    @RequestMapping("/login")
    public String login(@RequestBody User user) {
        String flag = "error";
        HashMap<String, Object> res = new HashMap<>();
        User longinUser = userDao.getUserByMessage(user.getUsername(), user.getPassword());
        if (longinUser != null) {
            flag = "ok";
        }
        res.put("flag", flag);
        res.put("user", longinUser);
        String resJson = JSON.toJSONString(res);
        System.out.println(resJson);
        return resJson;
    }
}
