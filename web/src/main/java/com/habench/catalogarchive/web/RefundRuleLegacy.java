package com.habench.catalogarchive.web;

public final class RefundRuleLegacy implements RefundRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
