package web.requestdata;

/**
 * Created by Wu Zhitao on 2018/03/28.
 * 存取和读取user数据
 */

public class FileData {
    private  Integer id;

    private String filename;

    private String filetype;

    private String upload_time;

    private String username;

    private String sign;

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
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

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
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

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "LoginData{" +
                "username='" + username + '\'' +
                ", filename='" + filename + '\'' +
                '}';
    }
}
