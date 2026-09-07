package com.habench.orderissue.dao;

public final class ChannelRuleStandard implements ChannelRule {
    @Override
    public void handle(String value) {
        QuoteFacade.assemble(value);
    }
}
