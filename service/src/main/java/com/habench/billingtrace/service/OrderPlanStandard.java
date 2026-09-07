package com.habench.billingtrace.service;

public final class OrderPlanStandard implements OrderPlan {
    @Override
    public void handle(String value) {
        ShipmentComposer.route(value);
    }
}
