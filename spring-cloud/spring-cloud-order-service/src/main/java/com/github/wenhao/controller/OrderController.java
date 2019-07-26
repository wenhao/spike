package com.github.wenhao.controller;

import com.github.wenhao.client.ProductServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private ProductServiceClient productServiceClient;

    @Autowired
    public OrderController(ProductServiceClient productServiceClient) {
        this.productServiceClient = productServiceClient;
    }

    @PostMapping
    public ResponseEntity create() {
        String eurekaService = productServiceClient.get();
        return ResponseEntity.ok(eurekaService);
    }
}
