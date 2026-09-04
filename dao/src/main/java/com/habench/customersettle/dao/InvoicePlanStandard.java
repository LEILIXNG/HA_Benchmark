package com.habench.customersettle.dao;

public final class InvoicePlanStandard implements InvoicePlan {
    @Override
    public void handle(String value) {
        PaymentComposer.assemble(value);
    }
}
