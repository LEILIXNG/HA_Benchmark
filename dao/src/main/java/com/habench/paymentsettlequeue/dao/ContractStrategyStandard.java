package com.habench.paymentsettlequeue.dao;

public final class ContractStrategyStandard implements ContractStrategy {
    @Override
    public void handle(String value) {
        OrderBroker.merge(value);
    }
}
