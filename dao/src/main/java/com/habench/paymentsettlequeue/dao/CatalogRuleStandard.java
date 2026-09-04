package com.habench.paymentsettlequeue.dao;

public final class CatalogRuleStandard implements CatalogRule {
    @Override
    public void handle(String value) {
        VoucherTranslator.expand(value);
    }
}
