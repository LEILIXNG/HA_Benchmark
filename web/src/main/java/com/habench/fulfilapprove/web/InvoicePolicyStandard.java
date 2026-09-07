package com.habench.fulfilapprove.web;

public final class InvoicePolicyStandard implements InvoicePolicy {
    @Override
    public void handle(String value) {
        ReceiptFacade.refine(value);
    }
}
