package web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Zhao Qing on 2017/11/28.
 * 数据分析页面
 */
@Controller
@RequestMapping("dataAnalysis")
public class DataAnalysisController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataAnalysisController.class);

    @GetMapping
    public String getDataAnalysis(){
        return "dataAnalysis";
    }
}
