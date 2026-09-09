package com.habench.vendorassign.web;

public final class TariffStrategyStandard implements TariffStrategy {
    @Override
    public void handle(String value) {
        BundleRegistry.forward(value);
    }
}
