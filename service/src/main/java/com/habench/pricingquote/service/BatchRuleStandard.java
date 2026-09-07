package com.habench.pricingquote.service;

public final class BatchRuleStandard implements BatchRule {
    @Override
    public void handle(String value) {
        ChannelTranslator.forward(value);
    }
}
