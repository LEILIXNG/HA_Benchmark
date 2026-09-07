package com.habench.customerdispatch.service;

public final class QuotePlanStandard implements QuotePlan {
    @Override
    public void handle(String value) {
        ManifestEnricher.refine(value);
    }
}
