package business.service;

import business.dao.UserRepository;
import business.entitys.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Zhao Qing on 2017/11/15.
 * 通过dao层来提供对user表的各种操作
 * 用户登陆时的各种状态，用户名是否存在、邮箱是否被注册、密码是否正确等
 */
@Service("userService")
public class UserService {

    @Autowired//自动注入
    private UserRepository userRepository;

    /**
     * 检查用户名是否存在
     * @param username
     * @return {true} if the username has been existed in our website's users; {false} if not.
     */
    public boolean isUserExist(String username){
        User user = userRepository.findByUsername(username);
        if (user != null){
            return true;
        }
        return false;
    }

    /**
     * 检查邮箱是否被注册
     * @param email
     * @return {true} if the email has been used for registering our website; {false} if not.
     */
    public boolean isEmailExist(String email){
        User user = userRepository.findByEmail(email);
        if (user != null){
            return true;
        }
        return false;
    }

    /**
     * 检查用户名与密码是否匹配
     * @param username
     * @param password
     * @return {true} if username and password is correct;{false} if username is not exist or password is wrong.
     */
    public boolean isUserValid(String username, String password){
        if (!isUserExist(username)){
            System.out.println("用户不存在");
            return false;
        }
        User user = userRepository.findByUsername(username);

        if (!user.getPassword().equals(password)){
            System.out.println(user);
            System.out.println("密码错误,user.getPassword():" + user.getPassword() + ",loginData.getPassword():" + password);
            return false;
        }
        return true;
    }

    /**
     * 保存一条user记录
     * @param user
     */
    public void save(User user){
        userRepository.save(user);
    }
}
