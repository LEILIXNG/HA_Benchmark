package com.northwind.inventoryledger.dao;

/**
 * 库存的默认处理策略。
 */
public final class TariffPlanStandard implements TariffPlan {

    @Override
    public void handle(String value) {
        ChannelEnricher.assemble(value);
    }
}
