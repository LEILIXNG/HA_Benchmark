package com.habench.shippingreopen.service;

public final class InvoiceRuleStandard implements InvoiceRule {
    @Override
    public void handle(String value) {
        CatalogRouter.prepare(value);
    }
}
