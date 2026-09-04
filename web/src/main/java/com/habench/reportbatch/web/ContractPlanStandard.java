package com.habench.reportbatch.web;

public final class ContractPlanStandard implements ContractPlan {
    @Override
    public void handle(String value) {
        BundleTranslator.expand(value);
    }
}
