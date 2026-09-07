package com.habench.catalogrelease.web;

public final class AccountPlanStandard implements AccountPlan {
    @Override
    public void handle(String value) {
        BatchEnricher.enrich(value);
    }
}
