package com.northwind.reportgrant.web;

/**
 * 报表处理策略的入口。
 */
public final class BundleStrategySelector {

    public static void collect(String value) {
        BundleStrategy handler = refine();
        handler.handle(value);
    }

    private static BundleStrategy refine() {
        return new BundleStrategyStandard();
    }
}
