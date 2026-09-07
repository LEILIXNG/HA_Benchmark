package com.habench.vendorsync.service;

public final class TariffPolicyStandard implements TariffPolicy {
    @Override
    public void handle(String value) {
        BatchFacade.compose(value);
    }
}
