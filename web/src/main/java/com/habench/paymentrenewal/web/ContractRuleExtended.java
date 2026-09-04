package com.habench.paymentrenewal.web;

public final class ContractRuleExtended implements ContractRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
