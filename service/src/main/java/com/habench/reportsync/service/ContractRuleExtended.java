package com.habench.reportsync.service;

public final class ContractRuleExtended implements ContractRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
