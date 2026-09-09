package com.habench.pricingrevise.web;

import com.habench.pricingrevise.web.ShipmentService;
import java.util.HashMap;
import java.util.Map;

public final class CatalogCollector {
    private static String cachedCatalog;

    public static void refine(String value) {
        Map<String, String> accountRef101Attrs = new HashMap<String, String>();
        accountRef101Attrs.put("channel", "web");
        accountRef101Attrs.put("payload", value);
        String accountRef101 = accountRef101Attrs.get("payload");
        cachedCatalog = accountRef101;
        attach();
    }

    private static void attach() {
        String voucherRef102 = cachedCatalog;
        String paymentTag103 = voucherRef102;
        ShipmentService.merge(paymentTag103);
    }
}
