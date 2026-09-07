package com.habench.fulfilreopen.web;

public final class VoucherPolicyStandard implements VoucherPolicy {
    @Override
    public void handle(String value) {
        InvoiceComposer.publish(value);
    }
}
