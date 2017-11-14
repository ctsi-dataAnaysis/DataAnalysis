package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Zhao Qing on 2017/11/14.
 */
@Controller
public class InspectController {

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }
}
