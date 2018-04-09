package business.service;


import business.dao.FileRepository;
import business.entitys.FileUpload;
import business.entitys.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Tianyi Xia on 2018/03/28.
 * 通过dao层来提供对file表的各种操作
 */
@Service("fileService")
@Transactional
public class FileService {

    @Autowired//自动注入
    private FileRepository fileRepository;

  /*  public boolean isFileValid(String username, String filename){
        FileUpload fileUpload = fileRepository.findByUsername(username);

        if (fileUpload.getFilename().equals(filename)){
            System.out.println(filename);
            return false;
        }
        return true;
    }
*/
    /**
     * 保存一条file记录
     * @param fileUpload
     */
    public void save(FileUpload fileUpload){
        fileRepository.save(fileUpload);
    }
}
