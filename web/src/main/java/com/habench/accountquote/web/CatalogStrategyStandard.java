package com.habench.accountquote.web;

public final class CatalogStrategyStandard implements CatalogStrategy {
    @Override
    public void handle(String value) {
        TariffRouter.normalize(value);
    }
}
