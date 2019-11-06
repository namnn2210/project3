package ginp14.project3.service;

import ginp14.project3.model.Order;

import java.util.List;

public interface OrderService {
    void save(Order order);
    List<Order> findByUserId(int id);
}
