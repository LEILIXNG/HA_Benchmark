package com.habench.fulfilimport.web;

public final class TariffStrategyStandard implements TariffStrategy {
    @Override
    public void handle(String value) {
        InvoiceCollector.attach(value);
    }
}
