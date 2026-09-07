package com.habench.billingquote.dao;

public final class ChannelRuleStandard implements ChannelRule {
    @Override
    public void handle(String value) {
        ContractNormalizer.refine(value);
    }
}
