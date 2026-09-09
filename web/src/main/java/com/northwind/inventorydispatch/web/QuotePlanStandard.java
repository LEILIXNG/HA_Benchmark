package com.northwind.inventorydispatch.web;

/**
 * 库存的默认处理策略。
 */
public final class QuotePlanStandard implements QuotePlan {

    @Override
    public void handle(String value) {
        VoucherEnricher.stage(value);
    }
}
