package com.habench.fulfilexport.web;

public final class QuotePlanStandard implements QuotePlan {
    @Override
    public void handle(String value) {
        ContractCollector.expand(value);
    }
}
