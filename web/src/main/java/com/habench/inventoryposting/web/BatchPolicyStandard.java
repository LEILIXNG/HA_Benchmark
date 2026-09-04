package com.habench.inventoryposting.web;

public final class BatchPolicyStandard implements BatchPolicy {
    @Override
    public void handle(String value) {
        CatalogBroker.compose(value);
    }
}
