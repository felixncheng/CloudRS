package io.github.chengmboy.cloudrs.ram.pojo.repository;

import io.github.chengmboy.cloudrs.ram.pojo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author cheng_mboy
 */
public interface UserRepository extends JpaRepository<User,Long>{

}
