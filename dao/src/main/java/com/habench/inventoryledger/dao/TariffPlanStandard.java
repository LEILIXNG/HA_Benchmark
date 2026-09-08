package com.habench.inventoryledger.dao;

public final class TariffPlanStandard implements TariffPlan {
    @Override
    public void handle(String value) {
        ChannelEnricher.assemble(value);
    }
}
