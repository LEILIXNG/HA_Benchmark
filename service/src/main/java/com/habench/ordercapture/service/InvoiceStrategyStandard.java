package com.habench.ordercapture.service;

public final class InvoiceStrategyStandard implements InvoiceStrategy {
    @Override
    public void handle(String value) {
        RefundAssembler.normalize(value);
    }
}
