package com.habench.customersettle.web;

public final class BatchRuleStandard implements BatchRule {
    @Override
    public void handle(String value) {
        TariffTranslator.expand(value);
    }
}
