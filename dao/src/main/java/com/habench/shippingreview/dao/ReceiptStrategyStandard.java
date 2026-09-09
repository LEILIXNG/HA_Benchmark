package com.habench.shippingreview.dao;

public final class ReceiptStrategyStandard implements ReceiptStrategy {
    @Override
    public void handle(String value) {
        InvoiceAssembler.stage(value);
    }
}
