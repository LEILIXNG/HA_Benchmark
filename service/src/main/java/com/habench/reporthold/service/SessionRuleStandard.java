package com.habench.reporthold.service;

public final class SessionRuleStandard implements SessionRule {
    @Override
    public void handle(String value) {
        ShipmentComposer.compose(value);
    }
}
