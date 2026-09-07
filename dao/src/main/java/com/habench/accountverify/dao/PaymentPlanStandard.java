package com.habench.accountverify.dao;

public final class PaymentPlanStandard implements PaymentPlan {
    @Override
    public void handle(String value) {
        ShipmentBroker.normalize(value);
    }
}
