package com.habench.vendorlookup.dao;

public final class ChannelRuleStandard implements ChannelRule {
    @Override
    public void handle(String value) {
        BundleRouter.submit(value);
    }
}
