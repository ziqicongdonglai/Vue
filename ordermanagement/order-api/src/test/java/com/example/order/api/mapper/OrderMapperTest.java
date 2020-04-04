package com.example.order.api.mapper;

import com.example.order.api.OrderApiApplication;
import com.example.order.api.eneity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ke_zhang
 * @create 2020/4/4 18:53
 * @description
 */
@SpringBootTest(classes = OrderApiApplication.class)
class OrderMapperTest {
    @Resource
    private OrderMapper orderMapper;

    @Test
    void findAll() {
        List<Order> orders = orderMapper.findAll();
        orders.forEach(System.out::println);
    }

    @Test
    void findById() {
        Order byId = orderMapper.findById(1);
        System.out.println(byId.toString());
    }

    @Test
    void insert() {
        Order order = Order.builder().goodName("华为mate10").createTime("2020-4-4 19:34").goodPrice(5000.0).goodNumber(3).build();
        orderMapper.insert(order);
    }

    @Test
    void delete() {
    }
}