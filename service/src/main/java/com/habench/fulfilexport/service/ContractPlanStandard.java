package com.habench.fulfilexport.service;

public final class ContractPlanStandard implements ContractPlan {
    @Override
    public void handle(String value) {
        CatalogComposer.refine(value);
    }
}
