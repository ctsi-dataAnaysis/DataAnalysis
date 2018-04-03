package web.controller;

import business.dao.FileRepository;
import business.entitys.FileUpload;
import business.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import web.requestdata.LoginData;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Zhao Qing on 2017/11/28.
 * "我的数据"页面
 * edit by Wu Zhitao, Tianyi Xia 2018/3/30
 * 添加文件上传并回显功能
 */
@Controller
@RequestMapping(value = "/userdata")
public class UserDataController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDataController.class);


    @Autowired
    private FileService fileService;

    @Autowired
    private FileRepository fileRepository;

//    @RequestMapping(value = "/getUserData")
    @GetMapping
    public String getUserData(HttpSession httpSession,
                              Model model, HttpServletResponse response){

        model.addAttribute("username",httpSession.getAttribute("username"));
        response.setHeader("Cache-Control", "no-cache, no-store");

        String username = "" + httpSession.getAttribute("username");

        List<FileUpload> list = fileRepository.findAll();

        for (int i = 0;i < list.size();i++){
            if (!list.get(i).getUsername().equals(username)){

                FileUpload item = list.get(i);

//                System.out.println(item);

                list.remove(item);

//                System.out.println(list);

                i -= 1;

            }
        }


        model.addAttribute("filelist",list);

//        request.setAttribute("imagesPath",path);
        return "userdata";
    }
}
