package com.habench.shippingledger.service;

public final class QuotePlanStandard implements QuotePlan {
    @Override
    public void handle(String value) {
        ChannelCollector.route(value);
    }
}
