package com.habench.shippingledger.web;

public final class LedgerStrategyStandard implements LedgerStrategy {
    @Override
    public void handle(String value) {
        BatchRouter.refine(value);
    }
}
