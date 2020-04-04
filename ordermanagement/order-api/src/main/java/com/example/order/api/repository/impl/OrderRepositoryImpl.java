package com.example.order.api.repository.impl;

import com.example.order.api.eneity.Order;
import com.example.order.api.mapper.OrderMapper;
import com.example.order.api.repository.OrderRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ke_zhang
 * @create 2020/4/4 16:30
 * @description
 */
@Repository
public class OrderRepositoryImpl implements OrderRepository {
    @Resource
    private OrderMapper orderMapper;

    @Override
    public List<Order> findAll() {
        return orderMapper.findAll();
    }

    @Override
    public Order findById(Integer id) {
        return orderMapper.findById(id);
    }

    @Override
    public Order insert(Order order) {
        return orderMapper.insert(order);
    }

    @Override
    public void delete(Integer id) {
        orderMapper.delete(id);
    }


//    @Override
//    public int update(Order order) {
//        return 0;
//    }
//
//    @Override
//    public int[] batchInsert(List<Order> orders) {
//        return new int[0];
//    }
}
