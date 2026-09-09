package com.habench.billingassign.web;

public final class ContractStrategyStandard implements ContractStrategy {
    @Override
    public void handle(String value) {
        ContractAdapter.compose(value);
    }
}
