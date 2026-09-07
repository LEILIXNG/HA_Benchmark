package com.habench.shippinggrant.dao;

public final class ChannelRuleStandard implements ChannelRule {
    @Override
    public void handle(String value) {
        InvoiceResolver.merge(value);
    }
}
