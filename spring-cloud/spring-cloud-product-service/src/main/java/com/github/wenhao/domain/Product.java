package com.github.wenhao.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class Product {
    private Long id;
    private String title;
    private BigDecimal salePrice;
}
