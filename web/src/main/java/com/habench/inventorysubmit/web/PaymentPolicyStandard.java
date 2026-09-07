package com.habench.inventorysubmit.web;

public final class PaymentPolicyStandard implements PaymentPolicy {
    @Override
    public void handle(String value) {
        ShipmentService.forward(value);
    }
}
