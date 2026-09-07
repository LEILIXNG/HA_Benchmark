package com.habench.reportverify.service;

public final class QuotePlanStandard implements QuotePlan {
    @Override
    public void handle(String value) {
        AccountFacade.attach(value);
    }
}
