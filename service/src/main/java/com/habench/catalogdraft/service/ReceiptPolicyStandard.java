package com.habench.catalogdraft.service;

public final class ReceiptPolicyStandard implements ReceiptPolicy {
    @Override
    public void handle(String value) {
        ContractComposer.route(value);
    }
}
