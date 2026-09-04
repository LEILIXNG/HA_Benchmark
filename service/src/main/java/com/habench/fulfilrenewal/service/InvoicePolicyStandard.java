package com.habench.fulfilrenewal.service;

public final class InvoicePolicyStandard implements InvoicePolicy {
    @Override
    public void handle(String value) {
        ManifestNormalizer.refine(value);
    }
}
