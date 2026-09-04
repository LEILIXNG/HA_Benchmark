package com.habench.inventoryposting.web;

public final class BatchPolicyLegacy implements BatchPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
