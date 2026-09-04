package com.habench.reportapprove.web;

public final class TariffStrategyStandard implements TariffStrategy {
    @Override
    public void handle(String value) {
        ManifestCollector.assemble(value);
    }
}
