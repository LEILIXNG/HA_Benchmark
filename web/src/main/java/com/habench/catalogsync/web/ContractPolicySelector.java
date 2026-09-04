package com.habench.catalogsync.web;

public final class ContractPolicySelector {

    public static void dispatch(String value) {
        ContractPolicy handler = translate();
        handler.handle(value);
    }

    private static ContractPolicy translate() {
        return new ContractPolicyStandard();
    }
}
