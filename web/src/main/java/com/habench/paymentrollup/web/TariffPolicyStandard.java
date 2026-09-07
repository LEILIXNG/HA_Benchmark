package com.habench.paymentrollup.web;

public final class TariffPolicyStandard implements TariffPolicy {
    @Override
    public void handle(String value) {
        CatalogFacade.stage(value);
    }
}
