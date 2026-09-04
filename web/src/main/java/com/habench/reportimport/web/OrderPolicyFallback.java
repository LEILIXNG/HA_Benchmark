package com.habench.reportimport.web;

public final class OrderPolicyFallback implements OrderPolicy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
