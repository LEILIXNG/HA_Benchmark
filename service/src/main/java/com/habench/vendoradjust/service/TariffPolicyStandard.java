package com.habench.vendoradjust.service;

public final class TariffPolicyStandard implements TariffPolicy {
    @Override
    public void handle(String value) {
        RefundComposer.compose(value);
    }
}
