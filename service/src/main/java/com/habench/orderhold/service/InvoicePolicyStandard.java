package com.habench.orderhold.service;

public final class InvoicePolicyStandard implements InvoicePolicy {
    @Override
    public void handle(String value) {
        ShipmentService.route(value);
    }
}
