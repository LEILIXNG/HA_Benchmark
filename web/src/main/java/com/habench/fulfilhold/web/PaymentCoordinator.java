package com.habench.fulfilhold.web;

import com.habench.fulfilhold.service.BundleFacade;

public final class PaymentCoordinator {
    private static String cachedReceipt;

    public static void compose(String value) {
        String shipmentCode101 = "ref:" + value + ";";
        cachedReceipt = shipmentCode101;
        normalize();
    }

    private static void normalize() {
        String manifestKey102 = cachedReceipt;
        String invoiceKey103 = "ref:" + manifestKey102 + ";";
        String batchTag104 = invoiceKey103;
        BundleFacade.refine(batchTag104);
    }
}
