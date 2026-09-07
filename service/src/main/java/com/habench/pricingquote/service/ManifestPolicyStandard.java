package com.habench.pricingquote.service;

public final class ManifestPolicyStandard implements ManifestPolicy {
    @Override
    public void handle(String value) {
        LedgerFacade.register(value);
    }
}
