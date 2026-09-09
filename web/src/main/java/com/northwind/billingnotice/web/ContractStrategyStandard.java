package com.northwind.billingnotice.web;

/**
 * 账务的默认处理策略。
 */
public final class ContractStrategyStandard implements ContractStrategy {

    @Override
    public void handle(String value) {
        OrderTranslator.register(value);
    }
}
