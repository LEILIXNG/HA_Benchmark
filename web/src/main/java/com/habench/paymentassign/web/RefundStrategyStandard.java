package com.habench.paymentassign.web;

public final class RefundStrategyStandard implements RefundStrategy {
    @Override
    public void handle(String value) {
        ChannelTranslator.enrich(value);
    }
}
