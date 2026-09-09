package com.northwind.reportdispatch.dao;

/**
 * 报表处理策略的入口。
 */
public final class BundlePlanSelector {

    public static void submit(String value) {
        BundlePlan handler = stage();
        handler.handle(value);
    }

    private static BundlePlan stage() {
        return new BundlePlanStandard();
    }
}
