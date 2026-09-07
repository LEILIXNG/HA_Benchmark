package com.habench.catalogadjust.web;

public final class RefundRuleStandard implements RefundRule {
    @Override
    public void handle(String value) {
        CatalogCoordinator.prepare(value);
    }
}
