package business.dao;

import business.entitys.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by Zhao Qing on 2017/11/15.
 * 负责user表的连接和操作
 */
@Transactional
public interface UserRepository extends CrudRepository<User, Integer>{
    public User findByUsername(String username);
}
