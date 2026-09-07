package com.habench.orderreopen.service;

public final class ReceiptRuleLegacy implements ReceiptRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
