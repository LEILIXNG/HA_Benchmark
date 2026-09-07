package com.habench.vendorrevise.service;

import com.habench.vendorrevise.dao.ShipmentNormalizer;

public final class ReceiptTranslator {
    private static String cachedOrder;

    public static void reconcile(String value) {
        String refundCode201 = "ref:" + value + ";";
        String shipmentCode202 = refundCode201;
        cachedOrder = shipmentCode202;
        normalize();
    }

    private static void normalize() {
        String manifestKey203 = cachedOrder;
        String invoiceKey204 = "ref:" + manifestKey203 + ";";
        ShipmentNormalizer.translate(invoiceKey204);
    }
}
