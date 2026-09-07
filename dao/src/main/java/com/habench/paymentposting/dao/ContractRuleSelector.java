package com.habench.paymentposting.dao;

public final class ContractRuleSelector {

    public static void forward(String value) {
        ContractRule handler = refine();
        handler.handle(value);
    }

    private static ContractRule refine() {
        return new ContractRuleStandard();
    }
}
