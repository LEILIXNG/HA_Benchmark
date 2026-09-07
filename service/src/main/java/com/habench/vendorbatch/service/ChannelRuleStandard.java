package com.habench.vendorbatch.service;

public final class ChannelRuleStandard implements ChannelRule {
    @Override
    public void handle(String value) {
        ReceiptFacade.assemble(value);
    }
}
