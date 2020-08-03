package io.github.chengmboy.cloudrs.uc.pojo.repository;

import io.github.chengmboy.cloudrs.uc.pojo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByRoleCode(String roleCode);
}
