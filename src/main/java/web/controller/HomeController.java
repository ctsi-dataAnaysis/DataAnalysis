package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by Zhao Qing on 2017/11/14.
 */

@Controller
//@SessionAttributes("username")
public class HomeController {

//    @ModelAttribute(value = "username")
//    public String getUserName(){return "赵庆";}

    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }
}
