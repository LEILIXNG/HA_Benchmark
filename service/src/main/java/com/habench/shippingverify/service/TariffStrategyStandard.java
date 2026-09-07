package com.habench.shippingverify.service;

public final class TariffStrategyStandard implements TariffStrategy {
    @Override
    public void handle(String value) {
        SessionAssembler.dispatch(value);
    }
}
