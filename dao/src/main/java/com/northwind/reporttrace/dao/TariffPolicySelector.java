package com.northwind.reporttrace.dao;

/**
 * 报表处理策略的入口。
 */
public final class TariffPolicySelector {

    public static void prepare(String value) {
        TariffPolicy handler = enrich();
        handler.handle(value);
    }

    private static TariffPolicy enrich() {
        return new TariffPolicyStandard();
    }
}
