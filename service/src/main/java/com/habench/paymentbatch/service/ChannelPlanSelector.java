package com.habench.paymentbatch.service;

public final class ChannelPlanSelector {

    public static void translate(String value) {
        ChannelPlan handler = assemble();
        handler.handle(value);
    }

    private static ChannelPlan assemble() {
        return new ChannelPlanStandard();
    }
}
