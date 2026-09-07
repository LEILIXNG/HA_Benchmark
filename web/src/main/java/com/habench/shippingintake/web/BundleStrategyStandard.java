package com.habench.shippingintake.web;

public final class BundleStrategyStandard implements BundleStrategy {
    @Override
    public void handle(String value) {
        OrderBroker.register(value);
    }
}
