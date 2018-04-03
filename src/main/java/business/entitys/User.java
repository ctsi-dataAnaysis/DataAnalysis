package business.entitys;

//import org.springframework.data.annotation.Id;
import utils.TimeUtil;
import web.requestdata.RegisterData;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Zhao Qing on 2017/11/15.
<<<<<<< HEAD
 * 对应数据库中的user表，获取user的相关数据
 */

@Entity    //对实体进行注释，Hibernate对象都需要此注释
@Table(name = "user")
public class User {

    @GeneratedValue    //标注主键的生成策略
=======
 * 对应数据库中的user表
 */
@Entity
@Table(name = "user")
public class User {

    @GeneratedValue
>>>>>>> 36eddb16c41b3c4c9420f4ffaf4edfba339b4949
    @Id
    private Integer id;//主键，自增

    private String username;//用户名

    private String password;//密码

    private String email;//用户邮箱

<<<<<<< HEAD
    private String createTime = TimeUtil.nowTime();//用户创建时间

    public User(){}

    //利用RegisterData来构造User对象，根据用户注册信息构造User对象
=======
    private String createTime;//用户创建时间

    public User(){
    }

    //利用RegisterData来构造User对象
>>>>>>> 36eddb16c41b3c4c9420f4ffaf4edfba339b4949
    public User(RegisterData registerData){
        this.username = registerData.getUsername();
        this.password = registerData.getPassword();
        this.email = registerData.getEmail();
<<<<<<< HEAD
=======
        this.createTime = TimeUtil.nowTime();
>>>>>>> 36eddb16c41b3c4c9420f4ffaf4edfba339b4949
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
