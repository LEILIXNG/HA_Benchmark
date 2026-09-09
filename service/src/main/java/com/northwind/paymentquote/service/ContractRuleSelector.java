package com.northwind.paymentquote.service;

/**
 * 支付处理策略的入口。
 */
public final class ContractRuleSelector {

    public static void route(String value) {
        ContractRule handler = register();
        handler.handle(value);
    }

    private static ContractRule register() {
        return new ContractRuleStandard();
    }
}
