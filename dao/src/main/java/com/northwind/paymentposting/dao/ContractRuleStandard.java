package com.northwind.paymentposting.dao;

/**
 * 支付的默认处理策略。
 */
public final class ContractRuleStandard implements ContractRule {

    @Override
    public void handle(String value) {
        LedgerBroker.compose(value);
    }
}
