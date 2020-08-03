package io.github.chengmboy.cloudrs.order.pojo.repository;

import io.github.chengmboy.cloudrs.order.pojo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
