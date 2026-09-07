package com.habench.inventorydispatch.web;

public final class ReceiptPolicyStandard implements ReceiptPolicy {
    @Override
    public void handle(String value) {
        ContractNormalizer.attach(value);
    }
}
