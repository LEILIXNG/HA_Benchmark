package com.northwind.pricingsettlequeue.service;

/**
 * 定价处理策略的入口。
 */
public final class CatalogRuleSelector {

    public static void expand(String value) {
        CatalogRule handler = publish();
        handler.handle(value);
    }

    private static CatalogRule publish() {
        return new CatalogRuleStandard();
    }
}
