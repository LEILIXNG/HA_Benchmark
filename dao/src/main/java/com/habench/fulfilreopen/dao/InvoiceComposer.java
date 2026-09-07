package com.habench.fulfilreopen.dao;

import com.habench.fulfilreopen.dao.OrderStrategySelector;

public final class InvoiceComposer {

    public static void enrich(String value) {
        String channelTag201 = value;
        OrderStrategySelector.assemble(channelTag201);
    }
}
