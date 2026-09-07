package com.habench.paymentquote.web;

public final class OrderPlanStandard implements OrderPlan {
    @Override
    public void handle(String value) {
        RefundCollector.attach(value);
    }
}
