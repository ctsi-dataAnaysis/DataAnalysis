package business.service;


import business.dao.FileRepository;
import business.entitys.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.requestdata.FileData;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tianyi Xia on 2018/03/28.
 * 通过dao层来提供对file表的各种操作
 */
@Service("fileService")
public class FileService {

    @Autowired//自动注入
    private FileRepository fileRepository;
//
//    public Map<String, String> getFileInformation(String username){
//        FileUpload fileUpload = fileRepository.findByUsername(username);
//
//        Map<String ,String> map = new HashMap<String, String>();
//        map.put("filename",fileUpload.getFilename());
//        map.put("filetype",fileUpload.getFiletype());
//        map.put("uploadtime",fileUpload.getUpload_time());
//
//        return map;
//    }

    /**
     * 保存一条file记录
     * @param fileUpload
     */
    public void save(FileUpload fileUpload){
        fileRepository.save(fileUpload);
    }
}
