package com.habench.reporttransfer.service;

public final class TariffPolicyStandard implements TariffPolicy {
    @Override
    public void handle(String value) {
        InvoiceBuilder.register(value);
    }
}
