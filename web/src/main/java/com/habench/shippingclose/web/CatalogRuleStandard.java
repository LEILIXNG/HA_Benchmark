package com.habench.shippingclose.web;

public final class CatalogRuleStandard implements CatalogRule {
    @Override
    public void handle(String value) {
        SessionRegistry.forward(value);
    }
}
