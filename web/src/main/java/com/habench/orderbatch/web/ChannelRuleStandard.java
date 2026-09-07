package com.habench.orderbatch.web;

public final class ChannelRuleStandard implements ChannelRule {
    @Override
    public void handle(String value) {
        CatalogBroker.publish(value);
    }
}
