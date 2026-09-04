package com.habench.paymentrenewal.web;

public final class ReceiptRuleStandard implements ReceiptRule {
    @Override
    public void handle(String value) {
        ReceiptAdapter.stage(value);
    }
}
