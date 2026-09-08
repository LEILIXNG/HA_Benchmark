package com.habench.inventorygrant.web;

public final class InvoicePolicyStandard implements InvoicePolicy {
    @Override
    public void handle(String value) {
        ReceiptFacade.refine(value);
    }
}
