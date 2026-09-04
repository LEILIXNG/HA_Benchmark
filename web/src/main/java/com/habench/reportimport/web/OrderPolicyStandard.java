package com.habench.reportimport.web;

public final class OrderPolicyStandard implements OrderPolicy {
    @Override
    public void handle(String value) {
        InvoiceCoordinator.register(value);
    }
}
