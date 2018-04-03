package web.controller;

import business.entitys.User;
import business.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private UserService userService;

    /**
     * 接收用户注册
     * @param registerData
     * @return {-1}用户名已存在;{-2}邮箱已被注册;{0}用户创建成功
     */
    @PostMapping
    @ResponseBody
    public String registerPost1(@RequestBody RegisterData registerData){
        LOGGER.debug("注册信息：" + registerData);
        if (userService.isUserExist(registerData.getUsername())){
            LOGGER.debug("用户名已存在");
            return "-1";
        }
        if (userService.isEmailExist(registerData.getEmail())){
            LOGGER.debug("邮箱已被注册");
            return "-2";
        }
<<<<<<< HEAD
        //创建新用户
=======
>>>>>>> 36eddb16c41b3c4c9420f4ffaf4edfba339b4949
        userService.save(new User(registerData));
        LOGGER.debug("用户创建成功");
        return "0";
    }

}
