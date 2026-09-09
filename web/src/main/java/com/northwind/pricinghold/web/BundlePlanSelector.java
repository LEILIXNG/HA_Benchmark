package com.northwind.pricinghold.web;

/**
 * 定价处理策略的入口。
 */
public final class BundlePlanSelector {

    public static void expand(String value) {
        BundlePlan handler = submit();
        handler.handle(value);
    }

    private static BundlePlan submit() {
        return new BundlePlanStandard();
    }
}
