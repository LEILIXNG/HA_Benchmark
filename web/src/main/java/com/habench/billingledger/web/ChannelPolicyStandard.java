package com.habench.billingledger.web;

public final class ChannelPolicyStandard implements ChannelPolicy {
    @Override
    public void handle(String value) {
        LedgerBroker.refine(value);
    }
}
