package web.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Zhao Qing on 2018/3/26.
 */
@Controller
@RequestMapping(value = "/quit")
public class QuitController {
    @GetMapping
    public String quit(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        if(!session.isNew()){session.invalidate();}
        return "index";
    }
}
