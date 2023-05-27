package kr.eddi.demo.order.repository;

import kr.eddi.demo.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
