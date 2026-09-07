package com.habench.customerverify.service;

import com.habench.customerverify.dao.AccountRegistry;

public final class ShipmentBroker {
    private static String cachedTariff;

    public static void submit(String value) {
        String invoiceKey401 = "ref:" + value + ";";
        cachedTariff = invoiceKey401;
        compose();
    }

    private static void compose() {
        String batchTag402 = cachedTariff;
        String orderRef403 = batchTag402;
        AccountRegistry.compose(orderRef403);
    }
}
