package com.habench.paymenttrace.dao;

public final class OrderStrategyStandard implements OrderStrategy {
    @Override
    public void handle(String value) {
        InvoiceService.enrich(value);
    }
}
