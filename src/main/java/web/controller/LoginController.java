package web.controller;

import business.service.UserService;
import com.sun.deploy.net.HttpResponse;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.requestdata.LoginData;

import javax.servlet.http.HttpServletRequest;
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
    public String login(@RequestBody LoginData loginData, Model model, HttpServletRequest request){
        LOGGER.debug("{}", loginData);
        if (!userService.isUserExist(loginData.getUsername())){
            return "-1";//用户名不存在
        }
        if (userService.isUserValid(loginData.getUsername(), loginData.getPassword())){
            System.out.println("用户有效");
            HttpSession session = request.getSession(true);//创建一个session
            session.setAttribute("username", loginData.getUsername());//设置username
//            model.addAttribute("username",loginData.getUsername());//设定属性
            return "0";//用户有效
        }
        System.out.println("用户无效");
        return "-2";//密码与用户名不匹配
    }


}
