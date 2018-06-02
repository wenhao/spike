package com.github.wenhao.service;

import com.github.wenhao.domain.Order;
import com.github.wenhao.request.OrderCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    public Order create(final OrderCreateRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Order> response = restTemplate.postForEntity("http://locahost:8080/orders", request, Order.class);
        return response.getBody();
    }
    
}
