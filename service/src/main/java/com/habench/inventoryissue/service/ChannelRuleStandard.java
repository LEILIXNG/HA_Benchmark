package com.habench.inventoryissue.service;

public final class ChannelRuleStandard implements ChannelRule {
    @Override
    public void handle(String value) {
        BatchTranslator.attach(value);
    }
}
