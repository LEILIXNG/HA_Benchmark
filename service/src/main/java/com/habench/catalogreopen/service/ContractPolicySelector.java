package com.habench.catalogreopen.service;

public final class ContractPolicySelector {

    public static void dispatch(String value) {
        ContractPolicy handler = prepare();
        handler.handle(value);
    }

    private static ContractPolicy prepare() {
        return new ContractPolicyStandard();
    }
}
