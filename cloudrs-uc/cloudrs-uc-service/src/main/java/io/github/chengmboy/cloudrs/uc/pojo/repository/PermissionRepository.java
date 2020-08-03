package io.github.chengmboy.cloudrs.uc.pojo.repository;

import io.github.chengmboy.cloudrs.uc.pojo.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission,Long> {
}
