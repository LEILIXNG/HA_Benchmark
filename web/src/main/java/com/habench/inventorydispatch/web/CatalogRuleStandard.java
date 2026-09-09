package com.habench.inventorydispatch.web;

public final class CatalogRuleStandard implements CatalogRule {
    @Override
    public void handle(String value) {
        ChannelNormalizer.refine(value);
    }
}
