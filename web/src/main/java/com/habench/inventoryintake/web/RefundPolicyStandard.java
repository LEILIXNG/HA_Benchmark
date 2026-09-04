package com.habench.inventoryintake.web;

public final class RefundPolicyStandard implements RefundPolicy {
    @Override
    public void handle(String value) {
        LedgerComposer.translate(value);
    }
}
