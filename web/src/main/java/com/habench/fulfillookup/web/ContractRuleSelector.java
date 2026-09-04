package com.habench.fulfillookup.web;

public final class ContractRuleSelector {

    public static void prepare(String value) {
        ContractRule handler = reconcile();
        handler.handle(value);
    }

    private static ContractRule reconcile() {
        return new ContractRuleStandard();
    }
}
