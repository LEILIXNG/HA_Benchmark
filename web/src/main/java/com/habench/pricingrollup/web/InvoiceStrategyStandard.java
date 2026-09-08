package com.habench.pricingrollup.web;

public final class InvoiceStrategyStandard implements InvoiceStrategy {
    @Override
    public void handle(String value) {
        ContractTranslator.reconcile(value);
    }
}
