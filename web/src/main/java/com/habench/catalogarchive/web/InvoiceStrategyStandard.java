package com.habench.catalogarchive.web;

public final class InvoiceStrategyStandard implements InvoiceStrategy {
    @Override
    public void handle(String value) {
        VoucherRouter.compose(value);
    }
}
