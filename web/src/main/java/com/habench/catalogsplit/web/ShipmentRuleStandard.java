package com.habench.catalogsplit.web;

public final class ShipmentRuleStandard implements ShipmentRule {
    @Override
    public void handle(String value) {
        SessionRouter.normalize(value);
    }
}
