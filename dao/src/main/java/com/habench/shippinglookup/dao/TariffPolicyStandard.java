package com.habench.shippinglookup.dao;

public final class TariffPolicyStandard implements TariffPolicy {
    @Override
    public void handle(String value) {
        VoucherResolver.stage(value);
    }
}
