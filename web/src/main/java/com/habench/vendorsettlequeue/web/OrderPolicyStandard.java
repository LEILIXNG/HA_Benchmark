package com.habench.vendorsettlequeue.web;

public final class OrderPolicyStandard implements OrderPolicy {
    @Override
    public void handle(String value) {
        ChannelRouter.stage(value);
    }
}
