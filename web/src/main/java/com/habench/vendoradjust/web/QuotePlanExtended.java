package com.habench.vendoradjust.web;

public final class QuotePlanExtended implements QuotePlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
