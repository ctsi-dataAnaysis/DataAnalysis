package web.controller;

import business.entitys.User;
import business.service.UserService;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import utils.TimeUtil;

/**
 * Created by Zhao Qing on 2017/11/16.
 * 注册页面
 */
@Controller
@RequestMapping(value = "/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping
    @ResponseBody
    public String registerGet(){
        return "register get";
    }

    @PostMapping
    @ResponseBody
    public String registerPost(@RequestBody String params){
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
//        User user = new User("walkingzq","123456","walkingzq@163.com", TimeUtil.nowTime());
//        userService.save(user);
        return "register post";
    }

}
