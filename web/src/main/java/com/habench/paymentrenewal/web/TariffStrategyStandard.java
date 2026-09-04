package com.habench.paymentrenewal.web;

public final class TariffStrategyStandard implements TariffStrategy {
    @Override
    public void handle(String value) {
        VoucherCoordinator.translate(value);
    }
}
