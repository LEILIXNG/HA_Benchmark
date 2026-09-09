package com.habench.catalogtransfer.web;

public final class RefundRuleStandard implements RefundRule {
    @Override
    public void handle(String value) {
        CatalogCoordinator.prepare(value);
    }
}
