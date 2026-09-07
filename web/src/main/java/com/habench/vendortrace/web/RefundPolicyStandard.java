package com.habench.vendortrace.web;

public final class RefundPolicyStandard implements RefundPolicy {
    @Override
    public void handle(String value) {
        InvoiceCoordinator.attach(value);
    }
}
