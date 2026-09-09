package com.northwind.inventorydispatch.web;

/**
 * 库存的默认处理策略。
 */
public final class TariffPlanStandard implements TariffPlan {

    @Override
    public void handle(String value) {
        InvoiceAssembler.register(value);
    }
}
