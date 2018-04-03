package web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import web.requestdata.LoginData;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Zhao Qing on 2017/11/28.
 * 数据分析页面
 */
@Controller
@RequestMapping("dataAnalysis")
public class DataAnalysisController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataAnalysisController.class);

    @GetMapping
    public String getDataAnalysis(@ModelAttribute LoginData loginData, HttpSession httpSession, Model model,HttpServletResponse response){

//        model.addAttribute("username",UserController.username);

        model.addAttribute("username",httpSession.getAttribute("username"));

        response.setHeader("Cache-Control", "no-cache, no-store");

        return "dataAnalysis";//跳转到dataAnalysis界面
    }
}
