package com.habench.fulfillookup.web;

public final class ContractRuleLegacy implements ContractRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
