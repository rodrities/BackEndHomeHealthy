package com.acme.homehealthy.MemberShip.resource;

public class OrderSubscriptionResource {
    private Long id;
    private Long amounthOfMonth;
    private Long totalPrice;

    public Long getId() {
        return id;
    }

    public OrderSubscriptionResource setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getAmounthOfMonth() {
        return amounthOfMonth;
    }

    public OrderSubscriptionResource setAmounthOfMonth(Long amounthOfMonth) {
        this.amounthOfMonth = amounthOfMonth;
        return this;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public OrderSubscriptionResource setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }
}
