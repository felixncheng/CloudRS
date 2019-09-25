package io.github.chengmboy.cloudrs.auth.pojo.repository;

import io.github.chengmboy.cloudrs.auth.pojo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author cheng_mboy
 */
public interface UserRepository extends JpaRepository<User,Long>{

    User findByLoginName(String loginName);
}
