package com.habench.reportbind.web;

public final class RefundRuleStandard implements RefundRule {
    @Override
    public void handle(String value) {
        ReceiptService.route(value);
    }
}
