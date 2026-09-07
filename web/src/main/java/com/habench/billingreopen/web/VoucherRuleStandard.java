package com.habench.billingreopen.web;

public final class VoucherRuleStandard implements VoucherRule {
    @Override
    public void handle(String value) {
        CatalogFacade.dispatch(value);
    }
}
