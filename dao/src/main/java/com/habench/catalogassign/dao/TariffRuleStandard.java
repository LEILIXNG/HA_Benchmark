package com.habench.catalogassign.dao;

public final class TariffRuleStandard implements TariffRule {
    @Override
    public void handle(String value) {
        AccountAdapter.dispatch(value);
    }
}
