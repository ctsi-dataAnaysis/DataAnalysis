package web.controller;

import business.service.UserService;
<<<<<<< HEAD
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
=======
import com.sun.deploy.net.HttpResponse;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
>>>>>>> 36eddb16c41b3c4c9420f4ffaf4edfba339b4949
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.requestdata.LoginData;

import javax.servlet.http.HttpServletRequest;
<<<<<<< HEAD
import javax.servlet.http.HttpServletResponse;
=======
>>>>>>> 36eddb16c41b3c4c9420f4ffaf4edfba339b4949
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

<<<<<<< HEAD
    @Autowired//不是很懂==
=======
    @Autowired
>>>>>>> 36eddb16c41b3c4c9420f4ffaf4edfba339b4949
    private UserService userService;

    @GetMapping
    public String getLogin(){
<<<<<<< HEAD
        return "login";//跳转到login界面
=======
        return "login";
>>>>>>> 36eddb16c41b3c4c9420f4ffaf4edfba339b4949
    }

    /**
     * 接收login请求
     * @param loginData
     * @return {0} 如果用户名和密码验证通过;{-1} 用户名不存在;{-2}密码不正确
     */
    @PostMapping
<<<<<<< HEAD
    @ResponseBody//将object返回json数据
    // login方法中利用@RequestBody将json数据返回一个object
=======
    @ResponseBody
>>>>>>> 36eddb16c41b3c4c9420f4ffaf4edfba339b4949
    public String login(@RequestBody LoginData loginData, Model model, HttpServletRequest request){
        LOGGER.debug("{}", loginData);
        if (!userService.isUserExist(loginData.getUsername())){
            return "-1";//用户名不存在
        }
        if (userService.isUserValid(loginData.getUsername(), loginData.getPassword())){
            System.out.println("用户有效");
<<<<<<< HEAD

            //如果用户登录成功，创建session，以保持登录状态
            HttpSession session = request.getSession(true);
//            model.addAttribute("username",loginData.getUsername());//设定属性
            session.setAttribute("username",loginData.getUsername());
=======
            HttpSession session = request.getSession(true);//创建一个session
            session.setAttribute("username", loginData.getUsername());//设置username
//            model.addAttribute("username",loginData.getUsername());//设定属性
>>>>>>> 36eddb16c41b3c4c9420f4ffaf4edfba339b4949
            return "0";//用户有效
        }
        System.out.println("用户无效");
        return "-2";//密码与用户名不匹配
    }

<<<<<<< HEAD
=======

>>>>>>> 36eddb16c41b3c4c9420f4ffaf4edfba339b4949
}
