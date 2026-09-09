package com.habench.vendorintake.service;

public final class ReceiptRuleStandard implements ReceiptRule {
    @Override
    public void handle(String value) {
        CatalogCoordinator.normalize(value);
    }
}
