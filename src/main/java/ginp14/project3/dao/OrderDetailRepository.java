package ginp14.project3.dao;

import ginp14.project3.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
    @Query(value = "SELECT od.* FROM order_detail od where od.order_id = ?1", nativeQuery = true)
    List<OrderDetail> findByOrderId(int id);
}
