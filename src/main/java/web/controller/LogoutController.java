package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Wu Zhitao on 2018/3/28
 *登出界面设计
 * */


@Controller
@RequestMapping(value = "/logout",method = RequestMethod.POST)
public class LogoutController {
    @GetMapping
    public String getLogout(HttpSession session, HttpServletRequest request, HttpServletResponse response){

        //清除session
        session.invalidate();

        //清除cookie
        Cookie[] cookies = request.getCookies();
        if (null == cookies){
            System.out.println("no cookies");
        }else {
            for (Cookie cookie:cookies){
                if (cookie.getName().equals("JSESSIONID")){
                    cookie.setValue(null);
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    break;
                }
            }
        }
        return "redirect:/";
    }
}
