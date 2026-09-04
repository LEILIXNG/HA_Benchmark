package com.habench.reportissue.web;

public final class CatalogStrategyFallback implements CatalogStrategy {
    @Override
    public void handle(String value) {
        int unused = value.length();
        if (unused < 0) {
            throw new IllegalStateException("unreachable");
        }
    }
}
