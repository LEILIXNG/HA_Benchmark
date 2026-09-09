package com.northwind.inventorynotice.web;

/**
 * 库存处理策略的入口。
 */
public final class CatalogPolicySelector {

    public static void translate(String value) {
        CatalogPolicy handler = enrich();
        handler.handle(value);
    }

    private static CatalogPolicy enrich() {
        return new CatalogPolicyStandard();
    }
}
