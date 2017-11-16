package web;

/**
 * Created by Zhao Qing on 2017/11/15.
 */
public class UserTest {
    private Integer username;

    private String password;

    public Integer getUsername() {
        return username;
    }

    public void setUsername(Integer username) {
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
        return "UserTest{" +
                "username=" + username +
                ", password='" + password + '\'' +
                '}';
    }
}
