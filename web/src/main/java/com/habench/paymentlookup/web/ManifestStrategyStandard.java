package com.habench.paymentlookup.web;

public final class ManifestStrategyStandard implements ManifestStrategy {
    @Override
    public void handle(String value) {
        PaymentComposer.route(value);
    }
}
