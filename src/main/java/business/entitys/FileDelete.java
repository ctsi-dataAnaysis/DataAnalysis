package business.entitys;

//import org.springframework.data.annotation.Id;

import utils.TimeUtil;
import web.requestdata.FileData;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by TianyiXia on 2018/03/28.
 * 对应数据库中的file_information表
 */
@Entity
@Table(name = "file_information")
public class FileDelete {

    @GeneratedValue
    @Id
    private Integer id;//主键，自增

    private String filename;//文件名

    private String filetype;//文件类型

    private String upload_time = TimeUtil.nowTime();//上传时间

    private String username;//用户名

    private String sign;

    public FileDelete(){
    }


    //利用RegisterData来构造User对象
    public FileDelete(FileData fileData){
        this.id = fileData.getId();
        this.filename = fileData.getFilename();
        this.filetype = fileData.getFiletype();
        this.upload_time = fileData.getUpload_time();
        this.username = fileData.getUsername();
        this.sign = fileData.getSign();
    }


    public FileDelete(Integer id, String filename, String filetype, String upload_time, String username, String sign) {
    this.id = id;
    this.filename = filename;
    this.filetype = filetype;
    this.upload_time = upload_time;
    this.username = username;
    this.sign = sign;

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String file_name) {
        this.filename = filename;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String file_type) {
        this.filetype = filetype;
    }

    public String getUpload_time() {
        return upload_time;
    }

    public void setUpload_time(String upload_time) {
        this.upload_time = upload_time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username){this.username = username;}

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }


    @Override
    public String toString() {
        return "FileDelete{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", filetype='" + filetype + '\'' +
                ", upload_time='" + upload_time + '\'' +
                ", username='" + username + '\'' +
                ", sep_sign='" + sign +'\'' +
                '}';
    }
}
