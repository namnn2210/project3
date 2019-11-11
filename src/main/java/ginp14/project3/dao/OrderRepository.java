package ginp14.project3.dao;

import ginp14.project3.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query(value = "SELECT o.* FROM orders o where o.user_id = ?1", nativeQuery = true)
    List<Order> findByUserId(int id );

    Order findById(int id);

    List<Order> findAllByStatus(boolean status);
}
