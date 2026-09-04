package com.habench.shippinglookup.dao;

public final class InvoicePlanStandard implements InvoicePlan {
    @Override
    public void handle(String value) {
        TariffBuilder.route(value);
    }
}
