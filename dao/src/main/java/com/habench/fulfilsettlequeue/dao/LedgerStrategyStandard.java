package com.habench.fulfilsettlequeue.dao;

public final class LedgerStrategyStandard implements LedgerStrategy {
    @Override
    public void handle(String value) {
        SessionCoordinator.resolve(value);
    }
}
