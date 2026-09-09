package com.habench.reportquote.service;

public final class QuotePlanStandard implements QuotePlan {
    @Override
    public void handle(String value) {
        CatalogFacade.resolve(value);
    }
}
