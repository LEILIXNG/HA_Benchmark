package com.habench.reportnotice.web;

public final class PaymentPolicyStandard implements PaymentPolicy {
    @Override
    public void handle(String value) {
        ShipmentFacade.expand(value);
    }
}
