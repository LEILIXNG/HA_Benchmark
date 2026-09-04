package com.habench.inventorymerge.service;

public final class BatchPolicyStandard implements BatchPolicy {
    @Override
    public void handle(String value) {
        CatalogRegistry.publish(value);
    }
}
