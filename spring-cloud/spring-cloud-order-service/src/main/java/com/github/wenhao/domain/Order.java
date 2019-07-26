package com.github.wenhao.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class Order {

    private Long id;
    private Product product;
    private Date timeCreated;
}
