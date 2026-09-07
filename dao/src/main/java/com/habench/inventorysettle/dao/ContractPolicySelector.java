package com.habench.inventorysettle.dao;

public final class ContractPolicySelector {

    public static void attach(String value) {
        ContractPolicy handler = reconcile();
        handler.handle(value);
    }

    private static ContractPolicy reconcile() {
        return new ContractPolicyStandard();
    }
}
