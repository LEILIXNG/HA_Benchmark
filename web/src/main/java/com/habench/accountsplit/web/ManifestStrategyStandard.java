package com.habench.accountsplit.web;

public final class ManifestStrategyStandard implements ManifestStrategy {
    @Override
    public void handle(String value) {
        ShipmentService.refine(value);
    }
}
