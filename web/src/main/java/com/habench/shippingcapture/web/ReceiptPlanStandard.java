package com.habench.shippingcapture.web;

public final class ReceiptPlanStandard implements ReceiptPlan {
    @Override
    public void handle(String value) {
        AccountCoordinator.translate(value);
    }
}
