package com.northwind.inventoryreview.dao;

/**
 * 库存处理策略的入口。
 */
public final class ManifestStrategySelector {

    public static void refine(String value) {
        ManifestStrategy handler = translate();
        handler.handle(value);
    }

    private static ManifestStrategy translate() {
        return new ManifestStrategyStandard();
    }
}
