package com.habench.customersettlequeue.dao;

public final class ContractPolicySelector {

    public static void refine(String value) {
        ContractPolicy handler = dispatch();
        handler.handle(value);
    }

    private static ContractPolicy dispatch() {
        return new ContractPolicyStandard();
    }
}
