package com.habench.vendorexport.web;

public final class BatchPlanStandard implements BatchPlan {
    @Override
    public void handle(String value) {
        ReceiptCollector.prepare(value);
    }
}
