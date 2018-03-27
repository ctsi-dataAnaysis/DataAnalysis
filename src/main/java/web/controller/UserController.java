package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Zhao Qing on 2017/11/20.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController{
    @GetMapping(value = "/{username}")
    public String userHome(HttpServletRequest request, Model model, HttpServletResponse response){
        HttpSession session = request.getSession();
        if (session.isNew()){return "login";}
        else {model.addAttribute("username", session.getAttribute("username"));}
        response.setHeader("Cache-Control", "no-cache");
        return "index";
    }
}
