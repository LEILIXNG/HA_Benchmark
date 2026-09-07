package com.habench.shippingsubmit.web;

public final class ChannelPolicyStandard implements ChannelPolicy {
    @Override
    public void handle(String value) {
        TariffEnricher.expand(value);
    }
}
