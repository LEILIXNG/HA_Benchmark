package com.habench.orderapprove.web;

public final class ShipmentRuleStandard implements ShipmentRule {
    @Override
    public void handle(String value) {
        RefundTranslator.refine(value);
    }
}
