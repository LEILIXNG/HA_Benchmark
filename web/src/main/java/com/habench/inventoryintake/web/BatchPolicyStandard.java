package com.habench.inventoryintake.web;

public final class BatchPolicyStandard implements BatchPolicy {
    @Override
    public void handle(String value) {
        ContractEnricher.reconcile(value);
    }
}
