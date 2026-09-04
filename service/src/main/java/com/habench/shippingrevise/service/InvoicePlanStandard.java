package com.habench.shippingrevise.service;

public final class InvoicePlanStandard implements InvoicePlan {
    @Override
    public void handle(String value) {
        BatchBroker.prepare(value);
    }
}
