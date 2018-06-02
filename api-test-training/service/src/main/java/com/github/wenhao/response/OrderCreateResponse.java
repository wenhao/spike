package com.github.wenhao.response;

public class OrderCreateResponse {
    private Long id;
    private String orderNo;

    public OrderCreateResponse(final Long id, final String orderNo) {
        this.id = id;
        this.orderNo = orderNo;
    }

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
