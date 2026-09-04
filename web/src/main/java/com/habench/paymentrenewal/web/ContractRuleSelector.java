package com.habench.paymentrenewal.web;

public final class ContractRuleSelector {

    public static void assemble(String value) {
        ContractRule handler = enrich();
        handler.handle(value);
    }

    private static ContractRule enrich() {
        return new ContractRuleStandard();
    }
}
