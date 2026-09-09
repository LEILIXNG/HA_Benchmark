package com.northwind.paymentposting.dao;

/**
 * 支付处理策略的入口。
 */
public final class ContractRuleSelector {

    public static void forward(String value) {
        ContractRule handler = refine();
        handler.handle(value);
    }

    private static ContractRule refine() {
        return new ContractRuleStandard();
    }
}
