package com.habench.billingsettlequeue.dao;

public final class TariffRuleFallback implements TariffRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
