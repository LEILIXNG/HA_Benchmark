package com.northwind.paymentlookup.dao;

/**
 * 支付的默认处理策略。
 */
public final class BatchRuleStandard implements BatchRule {

    @Override
    public void handle(String value) {
        QuoteRegistry.refine(value);
    }
}
