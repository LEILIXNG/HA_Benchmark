package com.habench.paymentsplit.web;

public final class VoucherRuleStandard implements VoucherRule {
    @Override
    public void handle(String value) {
        ReceiptAssembler.forward(value);
    }
}
