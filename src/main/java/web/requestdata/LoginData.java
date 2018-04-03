package web.requestdata;

/**
 * Created by Zhao Qing on 2017/11/17.
<<<<<<< HEAD
 * 获取用户信息
=======
>>>>>>> 36eddb16c41b3c4c9420f4ffaf4edfba339b4949
 */
public class LoginData {
    private String username;

    private String password;

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

    @Override
    public String toString() {
        return "LoginData{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
