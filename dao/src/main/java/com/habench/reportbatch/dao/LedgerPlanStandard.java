package com.habench.reportbatch.dao;

public final class LedgerPlanStandard implements LedgerPlan {
    @Override
    public void handle(String value) {
        ReceiptAssembler.expand(value);
    }
}
