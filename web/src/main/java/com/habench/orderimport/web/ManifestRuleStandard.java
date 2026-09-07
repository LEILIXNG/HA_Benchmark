package com.habench.orderimport.web;

public final class ManifestRuleStandard implements ManifestRule {
    @Override
    public void handle(String value) {
        VoucherResolver.reconcile(value);
    }
}
