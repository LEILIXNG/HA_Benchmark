package com.habench.fulfilissue.web;

public final class CatalogRuleStandard implements CatalogRule {
    @Override
    public void handle(String value) {
        SessionTranslator.collect(value);
    }
}
