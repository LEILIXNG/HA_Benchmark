package com.habench.ordersubmit.dao;

public final class ReceiptPolicyStandard implements ReceiptPolicy {
    @Override
    public void handle(String value) {
        InvoiceRouter.translate(value);
    }
}
