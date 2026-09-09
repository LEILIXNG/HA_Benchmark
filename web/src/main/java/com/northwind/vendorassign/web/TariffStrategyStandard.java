package com.northwind.vendorassign.web;

import org.springframework.stereotype.Component;

/**
 * 供应商的默认处理策略。
 */
@Component("vendorassignTariffStrategyStandard")
public class TariffStrategyStandard implements TariffStrategy {
    private final BundleRegistry bundleRegistry;

    public TariffStrategyStandard(BundleRegistry bundleRegistry) {
        this.bundleRegistry = bundleRegistry;
    }

    @Override
    public void handle(String value) {
        this.bundleRegistry.forward(value);
    }
}
