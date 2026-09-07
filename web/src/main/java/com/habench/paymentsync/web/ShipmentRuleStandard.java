package com.habench.paymentsync.web;

public final class ShipmentRuleStandard implements ShipmentRule {
    @Override
    public void handle(String value) {
        ManifestBroker.reconcile(value);
    }
}
