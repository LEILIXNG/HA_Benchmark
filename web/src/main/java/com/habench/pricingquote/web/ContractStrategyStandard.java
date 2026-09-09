package com.habench.pricingquote.web;

public final class ContractStrategyStandard implements ContractStrategy {
    @Override
    public void handle(String value) {
        CatalogNormalizer.route(value);
    }
}
