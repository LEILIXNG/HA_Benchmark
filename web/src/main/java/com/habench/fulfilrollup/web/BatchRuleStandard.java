package com.habench.fulfilrollup.web;

public final class BatchRuleStandard implements BatchRule {
    @Override
    public void handle(String value) {
        ManifestTranslator.refine(value);
    }
}
