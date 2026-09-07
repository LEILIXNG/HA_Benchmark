package com.habench.pricingissue.dao;

public final class CatalogStrategyStandard implements CatalogStrategy {
    @Override
    public void handle(String value) {
        ContractFacade.assemble(value);
    }
}
