package com.habench.vendorquote.web;

import com.habench.vendorquote.web.ShipmentPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class CatalogRouter {
    private static String cachedVoucher;

    public static void forward(String value) {
        String shipmentCode1 = value;
        String manifestKey2 = shipmentCode1;
        cachedVoucher = manifestKey2;
        register();
    }

    private static void register() {
        String invoiceKey3 = cachedVoucher;
        Map<String, String> batchTag4Attrs = new HashMap<String, String>();
        batchTag4Attrs.put("channel", "web");
        batchTag4Attrs.put("payload", invoiceKey3);
        String batchTag4 = batchTag4Attrs.get("payload");
        String orderRef5 = batchTag4;
        ShipmentPlanSelector.register(orderRef5);
    }
}
