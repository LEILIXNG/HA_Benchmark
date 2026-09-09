package com.habench.reportdispatch.dao;

public final class BundlePlanLegacy implements BundlePlan {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
