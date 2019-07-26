package com.github.wenhao.service;

import com.github.wenhao.client.ProductServiceClient;
import com.github.wenhao.domain.Order;
import com.github.wenhao.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ProductServiceClient productServiceClient;

    public Order create() {
        Product product = productServiceClient.get(1000L);
        return Order.builder()
                .id(2000L)
                .product(product)
                .timeCreated(new Date())
                .build();
    }
}
