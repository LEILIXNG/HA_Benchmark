package com.habench.vendorverify.web;

public final class InvoicePlanStandard implements InvoicePlan {
    @Override
    public void handle(String value) {
        ShipmentEnricher.expand(value);
    }
}
