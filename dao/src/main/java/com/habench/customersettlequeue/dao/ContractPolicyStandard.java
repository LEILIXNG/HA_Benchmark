package com.habench.customersettlequeue.dao;

public final class ContractPolicyStandard implements ContractPolicy {
    @Override
    public void handle(String value) {
        LedgerCoordinator.assemble(value);
    }
}
