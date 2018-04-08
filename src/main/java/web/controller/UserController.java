package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.requestdata.LoginData;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Zhao Qing on 2017/11/20.
 */
//@SessionAttributes("username")
@Controller
@RequestMapping(value = "/user",method = RequestMethod.POST)
public class UserController{


    @GetMapping(value = "/{username}")
    public String userHome(@ModelAttribute LoginData loginData, HttpSession session, HttpServletResponse response, Model model){

        model.addAttribute("username",session.getAttribute("username"));

        response.setHeader("Cache-Control", "no-cache, no-store");

        return "index";
    }
}
