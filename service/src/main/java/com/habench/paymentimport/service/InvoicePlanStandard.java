package com.habench.paymentimport.service;

public final class InvoicePlanStandard implements InvoicePlan {
    @Override
    public void handle(String value) {
        AccountRouter.resolve(value);
    }
}
