package com.habench.orderdraft.web;

public final class InvoiceStrategyStandard implements InvoiceStrategy {
    @Override
    public void handle(String value) {
        VoucherTranslator.translate(value);
    }
}
