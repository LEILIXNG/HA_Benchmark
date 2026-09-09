package com.habench.inventoryrelease.service;

import com.habench.inventoryrelease.service.OrderCollector;

public final class InvoiceResolver {

    public static void normalize(String value) {
        String shipmentCode101 = "ref:" + value + ";";
        OrderCollector.translate(shipmentCode101);
    }
}
