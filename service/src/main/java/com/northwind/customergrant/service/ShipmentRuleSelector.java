package com.northwind.customergrant.service;

/**
 * 客户处理策略的入口。
 */
public final class ShipmentRuleSelector {

    public static void submit(String value) {
        ShipmentRule handler = resolve();
        handler.handle(value);
    }

    private static ShipmentRule resolve() {
        return new ShipmentRuleStandard();
    }
}
