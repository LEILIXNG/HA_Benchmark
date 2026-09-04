package com.habench.shippingbatch.web;

public final class ShipmentPlanStandard implements ShipmentPlan {
    @Override
    public void handle(String value) {
        QuoteBuilder.compose(value);
    }
}
