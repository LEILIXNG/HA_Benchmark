package com.habench.paymentrollup.dao;

public final class BatchPlanStandard implements BatchPlan {
    @Override
    public void handle(String value) {
        ReceiptNormalizer.submit(value);
    }
}
