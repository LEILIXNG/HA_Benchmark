package com.habench.paymentimport.service;

import com.habench.paymentimport.service.ShipmentExecutor;

public final class AccountRouter {
    private static String cachedShipment;

    public static void resolve(String value) {
        String refundCode101 = "ref:" + value + ";";
        cachedShipment = refundCode101;
        prepare();
    }

    private static void prepare() {
        String shipmentCode102 = cachedShipment;
        String manifestKey103 = "ref:" + shipmentCode102 + ";";
        String invoiceKey104 = "ref:" + manifestKey103 + ";";
        cachedShipment = invoiceKey104;
        normalize();
    }

    private static void normalize() {
        String batchTag105 = cachedShipment;
        String orderRef106 = batchTag105;
        String quoteRef107 = "ref:" + orderRef106 + ";";
        ShipmentExecutor.normalize(quoteRef107);
    }
}
