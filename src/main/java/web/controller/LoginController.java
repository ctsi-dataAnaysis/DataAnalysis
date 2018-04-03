package web.controller;

import business.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.requestdata.LoginData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Created by Zhao Qing on 2017/11/15.
 * 登录页
 */
@Controller
//@SessionAttributes("username")
@RequestMapping(value = "/login")
public class LoginController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired//不是很懂==
    private UserService userService;

    @GetMapping
    public String getLogin(){
        return "login";//跳转到login界面
    }

    /**
     * 接收login请求
     * @param loginData
     * @return {0} 如果用户名和密码验证通过;{-1} 用户名不存在;{-2}密码不正确
     */
    @PostMapping
    @ResponseBody//将object返回json数据
    // login方法中利用@RequestBody将json数据返回一个object
    public String login(@RequestBody LoginData loginData, Model model, HttpServletRequest request){
        LOGGER.debug("{}", loginData);
        if (!userService.isUserExist(loginData.getUsername())){
            return "-1";//用户名不存在
        }
        if (userService.isUserValid(loginData.getUsername(), loginData.getPassword())){
            System.out.println("用户有效");

            //如果用户登录成功，创建session，以保持登录状态
            HttpSession session = request.getSession(true);
//            model.addAttribute("username",loginData.getUsername());//设定属性
            session.setAttribute("username",loginData.getUsername());
            return "0";//用户有效
        }
        System.out.println("用户无效");
        return "-2";//密码与用户名不匹配
    }

}
