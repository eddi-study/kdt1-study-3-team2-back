package kr.eddi.demo.order.repository;

import kr.eddi.demo.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("select o from product_order o join fetch o.product where o.account.userToken=:userToken")
    List<Order> findByUserToken(String userToken);
}
