package com.habench.catalogarchive.web;

public final class RefundRuleStandard implements RefundRule {
    @Override
    public void handle(String value) {
        AccountCollector.stage(value);
    }
}
