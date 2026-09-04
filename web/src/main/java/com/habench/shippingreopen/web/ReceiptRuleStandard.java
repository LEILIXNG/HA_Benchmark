package com.habench.shippingreopen.web;

public final class ReceiptRuleStandard implements ReceiptRule {
    @Override
    public void handle(String value) {
        OrderCoordinator.translate(value);
    }
}
