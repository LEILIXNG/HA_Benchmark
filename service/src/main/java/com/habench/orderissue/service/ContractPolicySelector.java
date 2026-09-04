package com.habench.orderissue.service;

public final class ContractPolicySelector {

    public static void dispatch(String value) {
        ContractPolicy handler = expand();
        handler.handle(value);
    }

    private static ContractPolicy expand() {
        return new ContractPolicyStandard();
    }
}
