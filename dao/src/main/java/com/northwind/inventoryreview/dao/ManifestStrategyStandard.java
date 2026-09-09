package com.northwind.inventoryreview.dao;

/**
 * 库存的默认处理策略。
 */
public final class ManifestStrategyStandard implements ManifestStrategy {

    @Override
    public void handle(String value) {
        BundleTranslator.dispatch(value);
    }
}
