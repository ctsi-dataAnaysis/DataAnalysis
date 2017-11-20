package web.controller;

import business.service.UserService;
import com.sun.deploy.net.HttpResponse;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.requestdata.LoginData;


/**
 * Created by Zhao Qing on 2017/11/15.
 * 登录页
 */
@Controller
//@SessionAttributes("username")
@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String getLogin(){
        return "login";
    }

    /**
     * 接收login请求
     * @param loginData
     * @return {0} 如果用户名和密码验证通过;{-1} 用户名不存在;{-2}密码不正确
     */
    @PostMapping
    @ResponseBody
    public String login(@RequestBody LoginData loginData, Model model){
        System.out.println(loginData);
        if (!userService.isUserExist(loginData.getUsername())){
            return "-1";//用户名不存在
//            return "login";
        }
        if (userService.isUserValid(loginData.getUsername(), loginData.getPassword())){
            System.out.println("用户有效");
            model.addAttribute("username",loginData.getUsername());//设定属性

//            username = loginData.getUsername();
            return "0";//用户有效
//            return "redirect:/user/" + loginData.getUsername();
        }
        System.out.println("用户无效");
        return "-2";//密码与用户名不匹配
//        return "login";
    }


}
