package com.northwind.inventoryledger.dao;

/**
 * 库存处理策略的入口。
 */
public final class TariffPlanSelector {

    public static void translate(String value) {
        TariffPlan handler = attach();
        handler.handle(value);
    }

    private static TariffPlan attach() {
        return new TariffPlanStandard();
    }
}
