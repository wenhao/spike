package com.github.wenhao.controller;

import com.github.wenhao.domain.Order;
import com.github.wenhao.request.OrderCreateRequest;
import com.github.wenhao.response.OrderCreateResponse;
import com.github.wenhao.response.OrderResponse;
import com.github.wenhao.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("orders")
public class OrderController {
    private OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(new OrderResponse(1L, "20180517", 50.50D));
    }

    @PostMapping
    public ResponseEntity<OrderCreateResponse> createOrder(@RequestBody OrderCreateRequest request) {
        Order order = orderService.create(request);
        return ResponseEntity.ok(new OrderCreateResponse(order.getId(), order.getOrderNo()));
    }
}
