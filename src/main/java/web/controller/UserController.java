package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Zhao Qing on 2017/11/20.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController{
    @GetMapping(value = "/{username}")
    public String userHome(@PathVariable String username, Model model){
        model.addAttribute("username",username);
        return "index";
    }
}
