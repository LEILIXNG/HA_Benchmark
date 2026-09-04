package com.habench.accountdraft.dao;

public final class VoucherRuleStandard implements VoucherRule {
    @Override
    public void handle(String value) {
        ChannelAdapter.dispatch(value);
    }
}
