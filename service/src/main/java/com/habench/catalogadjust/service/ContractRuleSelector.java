package com.habench.catalogadjust.service;

public final class ContractRuleSelector {

    public static void translate(String value) {
        ContractRule handler = register();
        handler.handle(value);
    }

    private static ContractRule register() {
        return new ContractRuleStandard();
    }
}
