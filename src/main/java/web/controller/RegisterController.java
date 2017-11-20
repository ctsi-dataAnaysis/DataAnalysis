package web.controller;

import business.entitys.User;
import business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import web.requestdata.RegisterData;

/**
 * Created by Zhao Qing on 2017/11/16.
 * 注册页面
 */
@Controller
@RequestMapping(value = "/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    /**
     * 接收用户注册
     * @param registerData
     * @return {-1}用户名已存在;{-2}邮箱已被注册;{0}用户创建成功
     */
    @PostMapping
    @ResponseBody
    public int registerPost1(@RequestBody RegisterData registerData){
        System.out.println("注册信息：" + registerData);
        String message;
        if (userService.isUserExist(registerData.getUsername())){
            message = "用户名已存在";
            System.out.println(message);
            return -1;
        }
        if (userService.isEmailExist(registerData.getEmail())){
            message = "邮箱已被注册";
            System.out.println(message);
            return -2;
        }
        userService.save(new User(registerData));
        message = "用户创建成功";
        System.out.println(message);
        return 0;
    }

}
