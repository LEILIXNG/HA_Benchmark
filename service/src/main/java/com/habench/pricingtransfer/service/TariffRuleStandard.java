package com.habench.pricingtransfer.service;

public final class TariffRuleStandard implements TariffRule {
    @Override
    public void handle(String value) {
        ReceiptAdapter.register(value);
    }
}
