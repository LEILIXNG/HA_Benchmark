package com.habench.customersubmit.web;

import com.habench.customersubmit.service.ChannelRegistry;

public final class ReceiptEnricher {
    private static String cachedCatalog;

    public static void merge(String value) {
        String shipmentCode1 = "ref:" + value + ";";
        cachedCatalog = shipmentCode1;
        compose();
    }

    private static void compose() {
        String manifestKey2 = cachedCatalog;
        String invoiceKey3 = manifestKey2;
        cachedCatalog = invoiceKey3;
        expand();
    }

    private static void expand() {
        String batchTag4 = cachedCatalog;
        String orderRef5 = batchTag4;
        ChannelRegistry.refine(orderRef5);
    }
}
