package com.habench.orderissue.service;

public final class ContractPolicyLegacy implements ContractPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
