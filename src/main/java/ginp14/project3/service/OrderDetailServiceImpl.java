package ginp14.project3.service;

import ginp14.project3.dao.OrderDetailRepository;
import ginp14.project3.model.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public void save(OrderDetail orderDetail) {
        orderDetailRepository.save(orderDetail);
    }

    @Override
    public List<OrderDetail> findByOrderId(int id) {
        return orderDetailRepository.findByOrderId(id);
    }
}
