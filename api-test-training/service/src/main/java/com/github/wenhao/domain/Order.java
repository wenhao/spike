package com.github.wenhao.domain;

public class Order {
    private Long id;
    private String orderNo;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(final String orderNo) {
        this.orderNo = orderNo;
    }
}
