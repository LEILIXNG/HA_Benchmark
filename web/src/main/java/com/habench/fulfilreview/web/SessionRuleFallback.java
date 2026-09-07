package com.habench.fulfilreview.web;

public final class SessionRuleFallback implements SessionRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
