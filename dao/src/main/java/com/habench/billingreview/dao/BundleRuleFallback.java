package com.habench.billingreview.dao;

public final class BundleRuleFallback implements BundleRule {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
