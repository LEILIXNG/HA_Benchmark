package com.habench.shippingtransfer.web;

public final class AccountPlanStandard implements AccountPlan {
    @Override
    public void handle(String value) {
        CatalogBroker.collect(value);
    }
}
