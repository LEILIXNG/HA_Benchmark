package com.habench.billingsettlequeue.dao;

public final class TariffRuleStandard implements TariffRule {
    @Override
    public void handle(String value) {
        QuoteFacade.forward(value);
    }
}
