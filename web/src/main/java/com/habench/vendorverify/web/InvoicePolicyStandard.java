package com.habench.vendorverify.web;

public final class InvoicePolicyStandard implements InvoicePolicy {
    @Override
    public void handle(String value) {
        LedgerAssembler.assemble(value);
    }
}
