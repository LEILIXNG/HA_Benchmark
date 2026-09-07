package com.habench.fulfilissue.web;

public final class TariffRuleStandard implements TariffRule {
    @Override
    public void handle(String value) {
        QuoteBroker.collect(value);
    }
}
