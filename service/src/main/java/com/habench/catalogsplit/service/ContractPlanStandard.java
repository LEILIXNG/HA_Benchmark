package com.habench.catalogsplit.service;

public final class ContractPlanStandard implements ContractPlan {
    @Override
    public void handle(String value) {
        ChannelAdapter.expand(value);
    }
}
