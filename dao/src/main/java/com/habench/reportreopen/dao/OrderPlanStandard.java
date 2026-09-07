package com.habench.reportreopen.dao;

public final class OrderPlanStandard implements OrderPlan {
    @Override
    public void handle(String value) {
        InvoiceBroker.normalize(value);
    }
}
