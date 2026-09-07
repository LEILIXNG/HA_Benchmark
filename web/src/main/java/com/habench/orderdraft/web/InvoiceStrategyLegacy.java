package com.habench.orderdraft.web;

public final class InvoiceStrategyLegacy implements InvoiceStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
