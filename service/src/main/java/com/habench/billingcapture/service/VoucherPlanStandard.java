package com.habench.billingcapture.service;

public final class VoucherPlanStandard implements VoucherPlan {
    @Override
    public void handle(String value) {
        ChannelTranslator.stage(value);
    }
}
