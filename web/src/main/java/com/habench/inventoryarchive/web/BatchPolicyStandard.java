package com.habench.inventoryarchive.web;

public final class BatchPolicyStandard implements BatchPolicy {
    @Override
    public void handle(String value) {
        RefundAssembler.resolve(value);
    }
}
