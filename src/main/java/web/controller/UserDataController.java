package web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Zhao Qing on 2017/11/28.
 * "我的数据"页面
 */
@Controller
@RequestMapping(value = "/userdata")
public class UserDataController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDataController.class);

    @GetMapping
    public String getUserData(){
        return "userdata";
    }


}
