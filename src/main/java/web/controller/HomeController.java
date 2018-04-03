package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Zhao Qing on 2017/11/14.
 */
/**
 * 主页？？？？
 * */
@Controller
//@SessionAttributes("username")
public class HomeController {

//    @ModelAttribute(value = "username")
//    public String getUserName(){return "赵庆";}

    @RequestMapping(value = "/")
    public String index(HttpSession httpSession, Model model, HttpServletResponse response){

        model.addAttribute("username",httpSession.getAttribute("username"));
        response.setHeader("Cache-Control", "no-cache, no-store");

        return "index";//跳转到index页面
    }


}
