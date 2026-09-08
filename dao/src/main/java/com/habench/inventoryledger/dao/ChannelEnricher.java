package com.habench.inventoryledger.dao;

import com.habench.inventoryledger.dao.BatchPlanSelector;

public final class ChannelEnricher {

    public static void assemble(String value) {
        String channelTag401 = "ref:" + value + ";";
        BatchPlanSelector.enrich(channelTag401);
    }
}
