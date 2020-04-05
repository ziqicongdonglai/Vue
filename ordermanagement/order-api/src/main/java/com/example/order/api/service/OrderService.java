package com.example.order.api.service;

import com.example.order.api.eneity.Order;

import java.util.List;

/**
 * @author ke_zhang
 * @create 2020/4/4 21:33
 * @description 消息服务接口
 */
public interface OrderService {
    List<Order> findAll();

    Order findById(Integer id);

    Order insert(Order order);

    void delete(Integer id);

    Order update(Order order);
//
//    int[] batchInsert(List<Order> orders);
}
