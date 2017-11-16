package web.controller;

import business.entitys.User;
import business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import web.UserTest;

import java.util.HashMap;

/**
 * Created by Zhao Qing on 2017/11/15.
 * 登录页
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    private UserService userService;

    private String message;//返回给model的提示信息

    @GetMapping
    public String getLogin(){
        return "login";
    }

    @PostMapping(value = "/register")
    public String login(@RequestBody HashMap<String,String> params){
        System.out.println("post请求接收成功：" + params);
        if (userService.isUserExist(params.get("username"))){
            message = "用户名已存在";
            System.out.println(message);
            return "login";
        }
        User user = new User(params.get("username"), params.get("password"), params.get("email"));
        userService.save(user);
        message = "用户创建成功";
        System.out.println(message);
        return "login";
    }

    @PostMapping(value = "/register1")
    public String login1(@RequestBody String params){
        System.out.println("post请求接收成功：" + params);
//        if (userService.isUserExist(params.get("username"))){
//            message = "用户名已存在";
//            System.out.println(message);
//            return "login";
//        }
//        User user = new User(params.get("username"), params.get("password"), params.get("email"));
//        userService.save(user);
//        message = "用户创建成功";
//        System.out.println(message);
        return "login";
    }

    @PostMapping(value = "/register2")
    public String login2(@RequestBody UserTest userTest){
        System.out.println(userTest);
        System.out.println("接收成功");
        return "login";
    }
    @PostMapping(value = "/register3")
    public String login3(@RequestParam UserTest userTest){
        System.out.println(userTest);
        System.out.println("接收成功");
        return "login";
    }
}
