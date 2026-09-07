package com.habench.shippingrevise.service;

public final class LedgerPlanStandard implements LedgerPlan {
    @Override
    public void handle(String value) {
        ReceiptCollector2.expand(value);
    }
}
