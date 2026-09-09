package com.habench.paymentledger.web;

public final class OrderPlanStandard implements OrderPlan {
    @Override
    public void handle(String value) {
        ShipmentResolver.refine(value);
    }
}
