package web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
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
    public String getDataAnalysis(HttpServletRequest request, Model model, HttpServletResponse response){
        HttpSession session = request.getSession();
        if(!session.isNew()){model.addAttribute("username", session.getAttribute("username"));}
        response.setHeader("Cache-Control", "no-cache");
        return "dataAnalysis";
    }
}
