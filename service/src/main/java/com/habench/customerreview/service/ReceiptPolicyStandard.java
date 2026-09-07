package com.habench.customerreview.service;

public final class ReceiptPolicyStandard implements ReceiptPolicy {
    @Override
    public void handle(String value) {
        InvoiceCollector.assemble(value);
    }
}
