package com.habench.catalogexport.service;

public final class LedgerRuleStandard implements LedgerRule {
    @Override
    public void handle(String value) {
        ChannelResolver.publish(value);
    }
}
