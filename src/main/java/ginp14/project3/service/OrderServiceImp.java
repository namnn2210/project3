package ginp14.project3.service;

import ginp14.project3.dao.OrderRepository;
import ginp14.project3.dao.UserRepository;
import ginp14.project3.model.Order;
import ginp14.project3.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public List<Order> findByUserId(int id) {
        return orderRepository.findByUserId(id);
    }
}
