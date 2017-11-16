package business.entitys;

//import org.springframework.data.annotation.Id;
import utils.TimeUtil;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Zhao Qing on 2017/11/15.
 * 对应数据库中的user表
 */
@Entity
@Table(name = "user")
public class User {

    @GeneratedValue
    @Id
    private Integer id;//主键，自增

    private String username;//用户名

    private String password;//密码

    private String email;//用户邮箱

    private String createTime;//用户创建时间

    public User(){
    }

    public User(String username, String password, String email,String createTime){
        this.username = username;
        this.password = password;
        this.email = email;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
