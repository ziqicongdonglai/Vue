package com.example.order.api.controller;

import com.example.order.api.eneity.Order;
import com.example.order.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ke_zhang
 * @create 2020/4/4 19:46
 * @description Order 控制器
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/order")
    public ResponseEntity<List<Order>> list() {
        List<Order> list = this.orderService.findAll();
        if (!list.isEmpty()) {
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("/order")
    public ResponseEntity<Order> create(@RequestBody Order order) {
        Order ord = this.orderService.insert(order);
        return ResponseEntity.ok(ord);
    }

    @PutMapping("/order")
    public ResponseEntity<Order> modify(@RequestBody Order order) {
        Order ord = this.orderService.update(order);
        return ResponseEntity.ok(ord);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Order> get(@PathVariable("id") Integer id) {
        Order ord = this.orderService.findById(id);
        return ResponseEntity.ok(ord);
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        this.orderService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
