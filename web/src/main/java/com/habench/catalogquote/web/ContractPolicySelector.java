package com.habench.catalogquote.web;

public final class ContractPolicySelector {

    public static void collect(String value) {
        ContractPolicy handler = refine();
        handler.handle(value);
    }

    private static ContractPolicy refine() {
        return new ContractPolicyStandard();
    }
}
