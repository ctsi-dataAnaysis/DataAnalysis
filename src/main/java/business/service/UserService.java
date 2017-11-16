package business.service;

import business.dao.UserRepository;
import business.entitys.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Zhao Qing on 2017/11/15.
 * 通过dao层来提供对user表的各种操作
 */
@Service("userService")
public class UserService {

    @Autowired//自动注入
    private UserRepository userRepository;

    public boolean isUserExist(String username){
        User userExist = userRepository.findByUsername(username);
        if (userExist != null){
            return true;
        }
        return false;
    }

    public void save(User user){
        userRepository.save(user);
    }
}
