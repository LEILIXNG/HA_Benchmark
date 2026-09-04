package com.habench.fulfilrollup.web;

public final class BatchPolicyFallback implements BatchPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
