package com.northwind.orderimport.web;

/**
 * 订单处理策略的入口。
 */
public final class ManifestRuleSelector {

    public static void refine(String value) {
        ManifestRule handler = enrich();
        handler.handle(value);
    }

    private static ManifestRule enrich() {
        return new ManifestRuleStandard();
    }
}
