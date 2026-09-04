package com.habench.orderreview.dao;

public final class ReceiptPlanStandard implements ReceiptPlan {
    @Override
    public void handle(String value) {
        ContractCollector.forward(value);
    }
}
