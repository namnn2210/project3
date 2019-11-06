package ginp14.project3.service;

import ginp14.project3.model.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    void save(OrderDetail orderDetail);
    List<OrderDetail> findByOrderId(int id);
}
