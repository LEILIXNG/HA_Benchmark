package com.habench.orderhold.service;

public final class TariffStrategyStandard implements TariffStrategy {
    @Override
    public void handle(String value) {
        InvoiceCollector.assemble(value);
    }
}
