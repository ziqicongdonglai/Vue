package com.example.order.api.service.impl;

import com.example.order.api.eneity.Order;
import com.example.order.api.repository.OrderRepository;
import com.example.order.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ke_zhang
 * @create 2020/4/4 21:34
 * @description
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository repository;
    @Override
    public List<Order> findAll() {
        return repository.findAll();
    }

    @Override
    public Order findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Order insert(Order order) {
        return repository.insert(order);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }

    @Override
    public Order update(Order order) {
        return repository.update(order);
    }
}
