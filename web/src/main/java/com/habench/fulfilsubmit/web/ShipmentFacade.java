package com.habench.fulfilsubmit.web;

import com.habench.fulfilsubmit.service.BundleComposer;

public final class ShipmentFacade {
    private static String cachedReceipt;

    public static void attach(String value) {
        String invoiceKey1 = value;
        cachedReceipt = invoiceKey1;
        merge();
    }

    private static void merge() {
        String batchTag2 = cachedReceipt;
        String orderRef3 = "ref:" + batchTag2 + ";";
        BundleComposer.submit(orderRef3);
    }
}
