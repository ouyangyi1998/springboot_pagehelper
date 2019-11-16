package com.jerry.springboot_pagehelper.controller;

import com.jerry.springboot_pagehelper.pojo.User;
import com.jerry.springboot_pagehelper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public boolean insert(@RequestBody User user) {
        System.out.println("开始新增...");
        return userService.insert(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public boolean update(@RequestBody User user) {
        System.out.println("开始更新...");
        return userService.update(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public boolean delete(@RequestParam int id)  {
        System.out.println("开始删除...");
        return userService.deleteByPrimaryKey(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> findByUser(User user,int num) {
        System.out.println("开始查询...");
        return userService.findByListEntity(user,num);
    }
    @RequestMapping(value = "/allUser")
    public List<User> findAll()
    {
        System.out.println("开始查询所有学生...");
        return userService.findAll();
    }
}
