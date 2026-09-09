package com.habench.catalogdispatch.dao;

public final class ContractPlanStandard implements ContractPlan {
    @Override
    public void handle(String value) {
        ManifestAssembler.merge(value);
    }
}
