package web.controller;

import business.dao.DeleteRepository;
import business.dao.FileRepository;
import business.entitys.FileDelete;
import business.entitys.FileUpload;
import business.entitys.User;
import business.service.DeleteService;
import business.service.FileService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/delete",method = RequestMethod.POST)
public class DeleteFileController {
    @Autowired
    private DeleteService deleteService;
    @Autowired
    private DeleteRepository deleteRepository;

    //    @ResponseBody
/*    @RequestMapping(value = "/delete")*/
    @Autowired
    FileRepository fileRepository;
    @GetMapping
    public String deleteUser(HttpSession httpSession,
                             Model model, HttpServletResponse response,HttpServletRequest request) {



        List<FileUpload> list = fileRepository.findAll();


        String username = "" + httpSession.getAttribute("username");
/*
        deleteRepository.delete(deleteRepository.findByUsername(username));
*/
        String items = request.getParameter("delitems");
        String[] strs = items.split(",");

        String pathRoot = request.getSession().getServletContext().getRealPath("") +
                "/static/" + httpSession.getAttribute("username");

        //删除文件
        for (int i =0; i < strs.length; i++){
            String filename = strs[i];
            for (int j = 0;j < list.size();j++){
                if (list.get(j).getUsername().equals(httpSession.getAttribute("username"))
                        && list.get(j).getFilename().equals(filename)){
                    /*System.out.println(list.get(j).getId());*/
                    deleteRepository.delete(deleteRepository.findById(list.get(j).getId()));
                }
            }


            File file = new File(pathRoot + "/" + filename);
            if (file.exists() && file.isFile()){
                file.delete();
            }
        }

       /*以下为按照id删除数据库信息，需要改写.当前为按照登录的用户名进行删除*/
       /*deleteRepository.delete(deleteRepository.findById(id));*/

       /*以下为删除服务器里的文件，需要编写*/
       /*String path = "";
        String filename = file.getOriginalFilename();
        path = "/static/" + httpSession.getAttribute("username") + "/" + filename;
        file.delete(new File(pathRoot + path));*/

        return "redirect:/userdata";
    }
}
