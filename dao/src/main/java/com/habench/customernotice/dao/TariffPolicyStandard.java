package com.habench.customernotice.dao;

public final class TariffPolicyStandard implements TariffPolicy {
    @Override
    public void handle(String value) {
        ReceiptRegistry.compose(value);
    }
}
