package com.habench.billingledger.web;

public final class ChannelPolicySelector {

    public static void merge(String value) {
        ChannelPolicy handler = reconcile();
        handler.handle(value);
    }

    private static ChannelPolicy reconcile() {
        return new ChannelPolicyStandard();
    }
}
