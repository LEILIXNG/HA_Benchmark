package com.habench.fulfilledger.web;

public final class TariffPolicyStandard implements TariffPolicy {
    @Override
    public void handle(String value) {
        RefundFacade.assemble(value);
    }
}
