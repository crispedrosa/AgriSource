package br.com.agrisource.order_service.service;

import br.com.agrisource.order_service.model.Order;
import br.com.agrisource.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order saveOrder(Order order) {
        order.setOrderDate(LocalDateTime.now());
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public Order updateOrder(Long id, Order orderDetails) {
        return orderRepository.findById(id).map(order -> {
            order.setUserId(orderDetails.getUserId());
            order.setTotalPrice(orderDetails.getTotalPrice());
            order.setItems(orderDetails.getItems());
            return orderRepository.save(order);
        }).orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    }
}
