package com.habench.pricingmanifest.web;

import com.habench.pricingmanifest.web.ShipmentEnricher;

public final class ContractResolver {
    private static String cachedContract;

    public static void stage(String value) {
        String shipmentCode1 = "ref:" + value + ";";
        cachedContract = shipmentCode1;
        register();
    }

    private static void register() {
        String manifestKey2 = cachedContract;
        String invoiceKey3 = manifestKey2;
        String batchTag4 = "ref:" + invoiceKey3 + ";";
        ShipmentEnricher.expand(batchTag4);
    }
}
