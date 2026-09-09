package com.northwind.inventorydispatch.web;

/**
 * 库存处理策略的入口。
 */
public final class CatalogRuleSelector {

    public static void publish(String value) {
        CatalogRule handler = submit();
        handler.handle(value);
    }

    private static CatalogRule submit() {
        return new CatalogRuleStandard();
    }
}
