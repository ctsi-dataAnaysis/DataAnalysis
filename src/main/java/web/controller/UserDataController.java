package web.controller;

import business.dao.FileRepository;
import business.entitys.FileUpload;
import business.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.requestdata.LoginData;

import javax.servlet.http.HttpServletRequest;
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

    private int totalPage;

    @Autowired
    private FileRepository fileRepository;

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
                list.remove(item);
                i -= 1;
            }
        }
        totalPage = (int) Math.ceil((double) list.size()/8);

        List<Object> pageData = new ArrayList<Object>();

        if (list.size()<8){
            for (int j = 0; j < list.size(); j++){
                pageData.add(list.get(j));
            }
        }else {
            for (int j = 0; j < 8; j++){
                pageData.add(list.get(j));
            }
        }

        model.addAttribute("totalpage",totalPage);
        model.addAttribute("filelist",pageData);
        model.addAttribute("currentPage",1);
        model.addAttribute("nextPage",2);
//        request.setAttribute("imagesPath",path);
        return "userdata";
    }

    @RequestMapping(value = "/page{i}")
    public String getPageData(@PathVariable(value = "i") int pageIndex,HttpSession session,
                              Model model,HttpServletResponse response){

        model.addAttribute("username",session.getAttribute("username"));
        response.setHeader("Cache-Control", "no-cache, no-store");

        String username = "" + session.getAttribute("username");

//        System.out.println("第" + pageIndex + "页");

        List<FileUpload> list = fileRepository.findAll();

        for (int i = 0; i < list.size();i++){
            if (!list.get(i).getUsername().equals(username)){
                FileUpload item = list.get(i);
                list.remove(item);
                i -= 1;
            }
        }

        List<Object> pageData = new ArrayList<Object>();

        if (list.size()<8){
            for (int j = 0; j < list.size(); j++){
                pageData.add(list.get(j));
            }
        }else {
            if (pageIndex != totalPage){
                for (int j = pageIndex*8-8; j < pageIndex*8; j++){
                    pageData.add(list.get(j));
                }
            }else {
                for (int j = pageIndex*8-8; j < list.size(); j++){
                    pageData.add(list.get(j));
                }
            }
        }

        model.addAttribute("totalpage",totalPage);
        model.addAttribute("filelist",pageData);
        model.addAttribute("currentPage",pageIndex);
        model.addAttribute("previousPage",pageIndex-1);
        model.addAttribute("nextPage",pageIndex+1);
//        request.setAttribute("imagesPath",path);
        return "userdata";
    }
}
