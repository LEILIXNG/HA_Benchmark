package com.northwind.shippingtransfer.dao;

/**
 * 发运的默认处理策略。
 */
public final class VoucherRuleStandard implements VoucherRule {

    @Override
    public void handle(String value) {
        AccountTranslator.attach(value);
    }
}
