package web.controller;

import business.entitys.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.requestdata.LoginData;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Zhao Qing on 2017/11/20.
 */
//@SessionAttributes("username")
@Controller
@RequestMapping(value = "/user",method = RequestMethod.POST)
public class UserController{

//    protected static String username;

    @GetMapping(value = "/{username}")
//    public String userHome(@ModelAttribute LoginData loginData, Model model){
//        //addAttribute(String attributeName, Object attributeValue)
//
//        username = loginData.getUsername();
////        System.out.println(this.username);
//        model.addAttribute("username",username);
//        return "index";
//    }
    public String userHome(@ModelAttribute LoginData loginData, HttpSession session, HttpServletResponse response, Model model){


        model.addAttribute("username",session.getAttribute("username"));

        response.setHeader("Cache-Control", "no-cache, no-store");

        return "index";
    }
}
