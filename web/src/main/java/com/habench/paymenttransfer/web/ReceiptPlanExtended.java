package com.habench.paymenttransfer.web;

public final class ReceiptPlanExtended implements ReceiptPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
