package com.habench.reportsync.service;

public final class ContractRuleSelector {

    public static void assemble(String value) {
        ContractRule handler = translate();
        handler.handle(value);
    }

    private static ContractRule translate() {
        return new ContractRuleStandard();
    }
}
