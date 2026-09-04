package com.habench.catalogsync.web;

public final class ContractPolicyStandard implements ContractPolicy {
    @Override
    public void handle(String value) {
        OrderRouter.forward(value);
    }
}
