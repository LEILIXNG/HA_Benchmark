package com.habench.customerposting.dao;

public final class AccountStrategyStandard implements AccountStrategy {
    @Override
    public void handle(String value) {
        InvoiceBuilder.refine(value);
    }
}
