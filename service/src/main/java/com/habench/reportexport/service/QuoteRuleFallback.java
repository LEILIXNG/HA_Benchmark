package com.habench.reportexport.service;

public final class QuoteRuleFallback implements QuoteRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
