package com.habench.pricingmerge.web;

import com.habench.pricingmerge.web.ShipmentStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class PaymentCoordinator {
    private static String cachedPayment;

    public static void assemble(String value) {
        Map<String, String> shipmentCode1Attrs = new HashMap<String, String>();
        shipmentCode1Attrs.put("channel", "web");
        shipmentCode1Attrs.put("payload", value);
        String shipmentCode1 = shipmentCode1Attrs.get("payload");
        String manifestKey2 = "ref:" + shipmentCode1 + ";";
        cachedPayment = manifestKey2;
        register();
    }

    private static void register() {
        String invoiceKey3 = cachedPayment;
        String batchTag4 = invoiceKey3;
        ShipmentStrategySelector.attach(batchTag4);
    }
}
