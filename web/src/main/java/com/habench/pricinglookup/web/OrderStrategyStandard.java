package com.habench.pricinglookup.web;

public final class OrderStrategyStandard implements OrderStrategy {
    @Override
    public void handle(String value) {
        ContractCoordinator.dispatch(value);
    }
}
