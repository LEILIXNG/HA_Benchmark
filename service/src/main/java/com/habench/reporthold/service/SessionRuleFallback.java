package com.habench.reporthold.service;

public final class SessionRuleFallback implements SessionRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
