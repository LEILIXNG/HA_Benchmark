package com.habench.reporttransfer.web;

public final class SessionRuleStandard implements SessionRule {
    @Override
    public void handle(String value) {
        ShipmentTranslator.submit(value);
    }
}
