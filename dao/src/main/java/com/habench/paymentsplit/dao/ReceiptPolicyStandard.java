package com.habench.paymentsplit.dao;

public final class ReceiptPolicyStandard implements ReceiptPolicy {
    @Override
    public void handle(String value) {
        VoucherAdapter.collect(value);
    }
}
