package com.habench.fulfilapprove.service;

public final class ReceiptPlanStandard implements ReceiptPlan {
    @Override
    public void handle(String value) {
        ChannelBuilder.forward(value);
    }
}
