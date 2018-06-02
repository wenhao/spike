package com.github.wenhao.response;

public class OrderResponse {
    private Long id;
    private String orderNo;
    private double price;
    private String comment;

    public OrderResponse(final long id, final String orderNo, final double price) {
        this.id = id;
        this.orderNo = orderNo;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(final String comment) {
        this.comment = comment;
    }
}
