package com.northwind.fulfilcapture.service;

/**
 * 履约处理策略的入口。
 */
public final class BundlePlanSelector {

    public static void route(String value) {
        BundlePlan handler = refine();
        handler.handle(value);
    }

    private static BundlePlan refine() {
        return new BundlePlanStandard();
    }
}
