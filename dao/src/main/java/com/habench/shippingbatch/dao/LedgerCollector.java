package com.habench.shippingbatch.dao;

import com.habench.shippingbatch.dao.CatalogExecutor;

public final class LedgerCollector {

    public static void enrich(String value) {
        String refundCode401 = value;
        String shipmentCode402 = refundCode401;
        CatalogExecutor.stage(shipmentCode402);
    }
}
