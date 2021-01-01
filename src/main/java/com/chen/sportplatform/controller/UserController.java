package com.chen.sportplatform.controller;

import com.alibaba.fastjson.JSON;
import com.chen.sportplatform.dao.UserDao;
import com.chen.sportplatform.entity.QueryInfo;
import com.chen.sportplatform.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserDao userDao;

    @RequestMapping("/allUser")
    public String getUserList(QueryInfo queryInfo) {
        HashMap<String, Object> res = new HashMap<>();
        int num = userDao.getUserCounts("%" + queryInfo.getQuery() + "%");
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();
        List<User> users = userDao.getAllUser("%"
                + queryInfo.getQuery()
                + "%", pageStart,
                queryInfo.getPageSize());
        res.put("numbers", num);
        res.put("data", users);
        String res_string= JSON.toJSONString(res);
        return res_string;
    }

    @RequestMapping("/userState")
    public String updateState(@RequestParam("id") Integer id,
                              @RequestParam("state") Boolean state) {
        int status = userDao.updateState(id, state);
        return status > 0 ? "success" : "error";
    }

    @RequestMapping("/addUser")
    public String addUser(@RequestBody User user) {
        user.setRole("Normal user");
        user.setState(false);
        int newUser = userDao.addUser(user);
        return newUser > 0 ? "success" : "error";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(int id) {
        int res = userDao.deleteUser(id);
        return res > 0 ? "success" : "error";
    }

    @RequestMapping("/getUpdate")
    public String getUpdateUser(int id) {
        User user = userDao.getUpdateUser(id);
        String user_string= JSON.toJSONString(user);
        return user_string;
    }

    @RequestMapping("/editUser")
    public String updateUser(@RequestBody User user) {
        int res = userDao.updateUser(user);
        return res > 0 ? "success" : "error";
    }

}
