package com.habench.ordercapture.service;

public final class InvoiceStrategyExtended implements InvoiceStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
