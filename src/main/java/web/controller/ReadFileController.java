package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

@Controller
@RequestMapping(value = "/userdata")
public class ReadFileController {

    private String filename;

//    @GetMapping
    @RequestMapping("/read")
    @ResponseBody
    public void readFile(HttpServletRequest request){
        filename = request.getParameter("filename");
//        model.addAttribute("filename",item);
    }

    @RequestMapping("/read/file")
//    @ResponseBody
    public String showFileContext(HttpServletRequest request, Model model,HttpServletResponse response, HttpSession session) throws Exception{

        String username = "" + session.getAttribute("username");
        String pathRoot = request.getSession().getServletContext().getRealPath("") +
                "/static/" + username;

        File file = new File(pathRoot + "/" + filename);

        String a[] = {""};
        String stra = "";
        try {
            String encoding = "UTF-8";
            if (file.isFile() && file.exists()){
                InputStreamReader reader = new InputStreamReader(new FileInputStream(file),encoding);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String context = null;
                while ((context = bufferedReader.readLine()) != null){
                    stra = stra + context + "\n";
                }
                reader.close();
//                String strb = stra.replace("\r\n","<br/>");
                String strc = stra.replace("\n","<br/>");
//                String strd = stra.replace("\r","<br/>");
//                System.out.println(strb);
//                System.out.println(strc);
//                System.out.println(strd);
                model.addAttribute("filecontext",strc);
            }
            else model.addAttribute("filecontext","找不到文件");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "file";
    }
}
