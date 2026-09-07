package com.habench.billingmerge.service;

public final class ReceiptRuleStandard implements ReceiptRule {
    @Override
    public void handle(String value) {
        VoucherAdapter.submit(value);
    }
}
