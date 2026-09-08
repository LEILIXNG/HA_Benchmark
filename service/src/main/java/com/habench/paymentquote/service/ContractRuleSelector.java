package com.habench.paymentquote.service;

public final class ContractRuleSelector {

    public static void route(String value) {
        ContractRule handler = register();
        handler.handle(value);
    }

    private static ContractRule register() {
        return new ContractRuleStandard();
    }
}
