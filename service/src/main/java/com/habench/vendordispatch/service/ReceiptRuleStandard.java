package com.habench.vendordispatch.service;

public final class ReceiptRuleStandard implements ReceiptRule {
    @Override
    public void handle(String value) {
        TariffCollector.attach(value);
    }
}
