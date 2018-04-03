package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

<<<<<<< HEAD
=======
import javax.servlet.http.HttpServletRequest;
>>>>>>> 36eddb16c41b3c4c9420f4ffaf4edfba339b4949
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Zhao Qing on 2017/11/14.
 */
<<<<<<< HEAD
/**
 * 主页？？？？
 * */
=======

>>>>>>> 36eddb16c41b3c4c9420f4ffaf4edfba339b4949
@Controller
//@SessionAttributes("username")
public class HomeController {

//    @ModelAttribute(value = "username")
//    public String getUserName(){return "赵庆";}

    @RequestMapping(value = "/")
<<<<<<< HEAD
    public String index(HttpSession httpSession, Model model, HttpServletResponse response){

        model.addAttribute("username",httpSession.getAttribute("username"));
        response.setHeader("Cache-Control", "no-cache, no-store");

        return "index";//跳转到index页面
=======
    public String index(HttpServletRequest request, Model model, HttpServletResponse response){
        HttpSession session = request.getSession();
        if(!session.isNew()){model.addAttribute("username", session.getAttribute("username"));}
        response.setHeader("Cache-Control", "no-cache");
        return "index";
>>>>>>> 36eddb16c41b3c4c9420f4ffaf4edfba339b4949
    }


}
