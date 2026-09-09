package com.habench.reportquote.service;

public final class InvoiceRuleStandard implements InvoiceRule {
    @Override
    public void handle(String value) {
        ChannelService.resolve(value);
    }
}
