package web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qaa on 2017/11/1.
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/")
    public String hello(){
        return "hello spring!";
    }
}
