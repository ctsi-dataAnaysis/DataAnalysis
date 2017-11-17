package web.controller;

import business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.requestdata.LoginData;


/**
 * Created by Zhao Qing on 2017/11/15.
 * 登录页
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    private UserService userService;

//    @ModelAttribute("username")
//    public String username(){return }

    private String message;//返回给model的提示信息

    @GetMapping
    public String getLogin(){
        return "login";
    }

    /**
     * 接收login请求
     * @param loginData
     * @return {登录成功界面} 如果用户名和密码验证通过;{login页面} 否则。
     */
    @PostMapping
//    @ResponseBody
    public String login(@RequestBody LoginData loginData, Model model){
        System.out.println(loginData);
        if (userService.isUserValid(loginData.getUsername(), loginData.getPassword())){
            System.out.println("用户有效");
            model.addAttribute("username",loginData.getUsername());//设定属性
            return "index";
        }
        System.out.println("用户无效");
        return "login";
    }

}
