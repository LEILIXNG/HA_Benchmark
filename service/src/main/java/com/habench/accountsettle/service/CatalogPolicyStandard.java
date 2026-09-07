package com.habench.accountsettle.service;

public final class CatalogPolicyStandard implements CatalogPolicy {
    @Override
    public void handle(String value) {
        BatchAssembler.compose(value);
    }
}
