package com.habench.reportimport.dao;

public final class ContractStrategyStandard implements ContractStrategy {
    @Override
    public void handle(String value) {
        LedgerBroker.register(value);
    }
}
