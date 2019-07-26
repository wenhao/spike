package com.github.wenhao.controller;

import com.github.wenhao.domain.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/products")
public class ProductServiceController {

    @GetMapping("/{productId}")
    public ResponseEntity get(@PathVariable Long productId) {
        Product product = Product.builder()
                .id(productId)
                .title("Nike")
                .salePrice(BigDecimal.valueOf(800))
                .build();
        return ResponseEntity.ok(product);
    }
}
