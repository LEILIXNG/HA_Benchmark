package com.habench.shippingcapture.web;

public final class ReceiptPlanLegacy implements ReceiptPlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
