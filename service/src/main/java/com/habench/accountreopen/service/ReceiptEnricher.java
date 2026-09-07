package com.habench.accountreopen.service;

import com.habench.accountreopen.dao.ShipmentAssembler;

public final class ReceiptEnricher {
    private static String cachedSession;

    public static void enrich(String value) {
        String voucherRef101 = value;
        cachedSession = voucherRef101;
        route();
    }

    private static void route() {
        String paymentTag102 = cachedSession;
        String refundCode103 = "ref:" + paymentTag102 + ";";
        cachedSession = refundCode103;
        refine();
    }

    private static void refine() {
        String shipmentCode104 = cachedSession;
        String manifestKey105 = "ref:" + shipmentCode104 + ";";
        ShipmentAssembler.assemble(manifestKey105);
    }
}
