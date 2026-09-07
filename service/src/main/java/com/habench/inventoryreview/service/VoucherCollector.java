package com.habench.inventoryreview.service;

import com.habench.inventoryreview.dao.OrderFacade;

public final class VoucherCollector {

    public static void route(String value) {
        String manifestKey301 = "ref:" + value + ";";
        OrderFacade.enrich(manifestKey301);
    }
}
