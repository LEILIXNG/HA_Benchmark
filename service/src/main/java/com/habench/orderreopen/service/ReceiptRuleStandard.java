package com.habench.orderreopen.service;

public final class ReceiptRuleStandard implements ReceiptRule {
    @Override
    public void handle(String value) {
        ManifestService.enrich(value);
    }
}
