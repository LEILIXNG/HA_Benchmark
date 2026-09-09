package com.habench.shippingposting.service;

public final class InvoicePolicyStandard implements InvoicePolicy {
    @Override
    public void handle(String value) {
        SessionFacade.reconcile(value);
    }
}
