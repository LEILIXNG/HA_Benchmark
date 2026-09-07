package com.habench.cataloggrant.service;

import com.habench.cataloggrant.dao.ShipmentService;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceBuilder {
    private static String cachedManifest;

    public static void route(String value) {
        String accountRef201 = value;
        cachedManifest = accountRef201;
        expand();
    }

    private static void expand() {
        String voucherRef202 = cachedManifest;
        Map<String, String> paymentTag203Attrs = new HashMap<String, String>();
        paymentTag203Attrs.put("channel", "web");
        paymentTag203Attrs.put("payload", voucherRef202);
        String paymentTag203 = paymentTag203Attrs.get("payload");
        ShipmentService.merge(paymentTag203);
    }
}
