package com.habench.inventoryverify.dao;

public final class TariffRuleStandard implements TariffRule {
    @Override
    public void handle(String value) {
        RefundComposer.submit(value);
    }
}
