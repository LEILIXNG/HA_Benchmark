package com.habench.accountverify.web;

public final class PaymentPlanStandard implements PaymentPlan {
    @Override
    public void handle(String value) {
        ShipmentBroker.normalize(value);
    }
}
