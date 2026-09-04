package com.habench.catalogreconcile.service;

public final class OrderStrategyStandard implements OrderStrategy {
    @Override
    public void handle(String value) {
        InvoiceCollector.compose(value);
    }
}
