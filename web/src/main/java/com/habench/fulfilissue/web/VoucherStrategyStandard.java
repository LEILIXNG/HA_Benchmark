package com.habench.fulfilissue.web;

public final class VoucherStrategyStandard implements VoucherStrategy {
    @Override
    public void handle(String value) {
        LedgerAssembler.stage(value);
    }
}
