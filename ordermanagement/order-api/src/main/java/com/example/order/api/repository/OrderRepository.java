package com.example.order.api.repository;

import com.example.order.api.eneity.Order;

import java.util.List;

/**
 * @author ke_zhang
 * @create 2020/4/4 16:29
 * @description Order的数据访问接口
 */
public interface OrderRepository {
    List<Order> findAll();

    Order findById(Integer id);

    Order insert(Order order);

    void delete(Integer id);

    Order update(Order order);
//
//    int[] batchInsert(List<Order> orders);

}
