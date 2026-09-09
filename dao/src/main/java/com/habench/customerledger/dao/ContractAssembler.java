package com.habench.customerledger.dao;

import com.habench.customerledger.dao.ShipmentFetcher;

public final class ContractAssembler {
    private static String cachedShipment;

    public static void prepare(String value) {
        String refundCode301 = "ref:" + value + ";";
        cachedShipment = refundCode301;
        refine();
    }

    private static void refine() {
        String shipmentCode302 = cachedShipment;
        String manifestKey303 = shipmentCode302;
        String invoiceKey304 = manifestKey303;
        ShipmentFetcher.attach(invoiceKey304);
    }
}
