package com.acme.homehealthy.MemberShip.resource;

import com.sun.istack.NotNull;

public class SaveOrderSubscriptionResource {
    @NotNull
    private Long amounthOfMonth;

    public Long getAmounthOfMonth() {
        return amounthOfMonth;
    }

    public SaveOrderSubscriptionResource setAmounthOfMonth(Long amounthOfMonth) {
        this.amounthOfMonth = amounthOfMonth;
        return this;
    }
}
