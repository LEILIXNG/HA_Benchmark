package com.habench.shippingledger.web;

public final class InvoicePolicyStandard implements InvoicePolicy {
    @Override
    public void handle(String value) {
        ChannelCollector.route(value);
    }
}
