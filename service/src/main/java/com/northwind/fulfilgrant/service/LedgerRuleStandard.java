package com.northwind.fulfilgrant.service;

/**
 * 履约的默认处理策略。
 */
public final class LedgerRuleStandard implements LedgerRule {

    @Override
    public void handle(String value) {
        LedgerNormalizer.expand(value);
    }
}
