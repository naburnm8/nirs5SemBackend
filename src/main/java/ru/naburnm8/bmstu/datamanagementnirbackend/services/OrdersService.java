package ru.naburnm8.bmstu.datamanagementnirbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.naburnm8.bmstu.datamanagementnirbackend.models.Orders;
import ru.naburnm8.bmstu.datamanagementnirbackend.repositories.OrdersRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;

    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    public Optional<Orders> getOrderById(int id) {
        return ordersRepository.findById(id);
    }

    public Orders createOrder(Orders order) {
        return ordersRepository.save(order);
    }

    public void deleteOrderById(int id) {
        ordersRepository.deleteById(id);
    }

    public Orders updateOrderById(int id, Orders updatedOrder) {
        return ordersRepository.findById(id).map(order -> {
            order.setItem(updatedOrder.getItem());
            order.setqItem(updatedOrder.getqItem());
            order.setDateOfTransaction(updatedOrder.getDateOfTransaction());
            order.setClient(updatedOrder.getClient());
            return ordersRepository.save(order);
        }).orElseGet(() -> {
            updatedOrder.setId(id);
            return ordersRepository.save(updatedOrder);
        });
    }

}
