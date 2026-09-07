package com.habench.inventorysettle.dao;

public final class ContractPolicyStandard implements ContractPolicy {
    @Override
    public void handle(String value) {
        ManifestTranslator.normalize(value);
    }
}
