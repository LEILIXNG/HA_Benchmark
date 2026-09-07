package com.habench.paymentrenewal.web;

public final class QuotePlanStandard implements QuotePlan {
    @Override
    public void handle(String value) {
        ManifestRegistry.route(value);
    }
}
