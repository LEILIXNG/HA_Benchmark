package com.northwind.billingrollup.web;

/**
 * 账务的默认处理策略。
 */
public final class LedgerRuleStandard implements LedgerRule {

    @Override
    public void handle(String value) {
        SessionNormalizer.stage(value);
    }
}
