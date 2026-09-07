package com.habench.billingcapture.service;

public final class VoucherPlanSelector {

    public static void forward(String value) {
        VoucherPlan handler = expand();
        handler.handle(value);
    }

    private static VoucherPlan expand() {
        return new VoucherPlanStandard();
    }
}
