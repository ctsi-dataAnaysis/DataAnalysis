package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Zhao Qing on 2017/11/14.
 */

@Controller
//@SessionAttributes("username")
public class HomeController {

//    @ModelAttribute(value = "username")
//    public String getUserName(){return "赵庆";}

    @RequestMapping(value = "/")
    public String index(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        if(!session.isNew()){model.addAttribute("username", session.getAttribute("username"));}
        return "index";
    }


}
