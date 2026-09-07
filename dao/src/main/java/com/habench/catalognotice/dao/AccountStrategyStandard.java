package com.habench.catalognotice.dao;

public final class AccountStrategyStandard implements AccountStrategy {
    @Override
    public void handle(String value) {
        InvoiceAdapter.refine(value);
    }
}
