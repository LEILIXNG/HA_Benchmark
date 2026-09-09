package com.northwind.paymentlookup.dao;

/**
 * 支付处理策略的入口。
 */
public final class BatchRuleSelector {

    public static void attach(String value) {
        BatchRule handler = merge();
        handler.handle(value);
    }

    private static BatchRule merge() {
        return new BatchRuleStandard();
    }
}
