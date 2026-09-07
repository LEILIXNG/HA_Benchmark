package com.habench.catalogarchive.web;

public final class InvoiceStrategyFallback implements InvoiceStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
