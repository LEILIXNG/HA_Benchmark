package com.habench.inventorydraft.web;

public final class ChannelPolicyStandard implements ChannelPolicy {
    @Override
    public void handle(String value) {
        VoucherRouter.stage(value);
    }
}
