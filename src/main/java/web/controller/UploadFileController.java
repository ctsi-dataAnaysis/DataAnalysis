package web.controller;

import business.entitys.FileUpload;
import business.entitys.User;
import business.service.FileService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import utils.TimeUtil;
import web.requestdata.FileData;
import web.requestdata.LoginData;
import web.requestdata.RegisterData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.logging.Logger;

/**
 * Created by Wu Zhitao on 2018/3/27.
 * 文件上传功能实现
 */

@Controller
@RequestMapping(value = "/userdata/upload",method = RequestMethod.POST)
public class UploadFileController {
//    private static final Logger LOGGER = LoggerFactory.getLogger(UploadFileController.class);

    @Autowired
    private FileService fileService;

    @GetMapping
//    @ResponseBody
    public String uploadFile(@ModelAttribute LoginData loginData,
                             @RequestParam("inputfile") MultipartFile file,
                             FileData fileData,
                             HttpSession httpSession, Model model,
                             HttpServletRequest request, HttpServletResponse response) throws Exception {

        model.addAttribute("username",httpSession.getAttribute("username"));
        response.setHeader("Cache-Control", "no-cache, no-store");

        String name = "";
        //获得物理webapp的路径
        String pathRoot = request.getSession().getServletContext().getRealPath("");
        String path = "";
        if (httpSession.getAttribute("username") != null){
            if (!file.isEmpty()) {
                //获得原始文件名
                String filename = file.getOriginalFilename();
                //sign
                String sign = request.getParameter("sign");
                //在webapp所在目录下根据username单独创建一个路径
                path = "/static/" + httpSession.getAttribute("username") + "/" + filename;

                name = "" + httpSession.getAttribute("username");

                //获取路径，如果路径为空则创建相应文件夹
                File file1 = new File(pathRoot + path);
                if (!file1.exists()) {
                    file1.mkdirs();
                }
                //文件存储
                file.transferTo(new File(pathRoot + path));

                //获取文件后缀名
                String prefix=filename.substring(filename.lastIndexOf(".")+1);
                //去除后缀名的文件名
                /*String fname = filename.replaceAll("." + prefix,"");*/

                //上传成功后将文件信息写入MySQL
                fileData.setFilename(filename);
                fileData.setFiletype(prefix);
                fileData.setUpload_time(TimeUtil.nowTime());
                fileData.setUsername(name);
                fileData.setSign(sign);
                fileService.save(new FileUpload(fileData));

            }
            return "redirect:/userdata";
        }else {return "redirect:/login";}
    }

}
