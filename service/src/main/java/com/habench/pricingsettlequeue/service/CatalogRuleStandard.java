package com.habench.pricingsettlequeue.service;

public final class CatalogRuleStandard implements CatalogRule {
    @Override
    public void handle(String value) {
        VoucherTranslator.submit(value);
    }
}
