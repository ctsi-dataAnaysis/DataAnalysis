package business.dao;

import business.entitys.User;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
=======
import org.springframework.data.repository.CrudRepository;
>>>>>>> 36eddb16c41b3c4c9420f4ffaf4edfba339b4949
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by Zhao Qing on 2017/11/15.
 * 负责user表的连接和操作
<<<<<<< HEAD
 * 定义接口，通过Username或者Email查找用户
 */
@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
=======
 */
@Transactional
public interface UserRepository extends CrudRepository<User, Integer>{
>>>>>>> 36eddb16c41b3c4c9420f4ffaf4edfba339b4949
    public User findByUsername(String username);
    public User findByEmail(String email);
}
