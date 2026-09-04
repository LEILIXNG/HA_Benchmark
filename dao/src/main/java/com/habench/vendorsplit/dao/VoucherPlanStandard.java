package com.habench.vendorsplit.dao;

public final class VoucherPlanStandard implements VoucherPlan {
    @Override
    public void handle(String value) {
        ReceiptService.compose(value);
    }
}
