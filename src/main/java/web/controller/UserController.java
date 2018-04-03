package web.controller;

<<<<<<< HEAD
import business.entitys.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.requestdata.LoginData;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;
=======
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
>>>>>>> 36eddb16c41b3c4c9420f4ffaf4edfba339b4949

/**
 * Created by Zhao Qing on 2017/11/20.
 */
<<<<<<< HEAD
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

=======
@Controller
@RequestMapping(value = "/user")
public class UserController{
    @GetMapping(value = "/{username}")
    public String userHome(HttpServletRequest request, Model model, HttpServletResponse response){
        HttpSession session = request.getSession();
        if (session.isNew()){return "login";}
        else {model.addAttribute("username", session.getAttribute("username"));}
        response.setHeader("Cache-Control", "no-cache");
>>>>>>> 36eddb16c41b3c4c9420f4ffaf4edfba339b4949
        return "index";
    }
}
