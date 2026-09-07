package com.habench.paymentadjust.web;

import com.habench.paymentadjust.web.CatalogCollector;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentAdapter {

    public static void attach(String value) {
        Map<String, String> accountRef1Attrs = new HashMap<String, String>();
        accountRef1Attrs.put("channel", "web");
        accountRef1Attrs.put("payload", value);
        String accountRef1 = accountRef1Attrs.get("payload");
        CatalogCollector.resolve(accountRef1);
    }
}
