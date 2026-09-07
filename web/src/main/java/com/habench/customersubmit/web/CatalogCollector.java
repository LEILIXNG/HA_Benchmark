package com.habench.customersubmit.web;

import com.habench.customersubmit.service.VoucherEnricher;
import java.util.HashMap;
import java.util.Map;

public final class CatalogCollector {

    public static void publish(String value) {
        Map<String, String> shipmentCode1Attrs = new HashMap<String, String>();
        shipmentCode1Attrs.put("channel", "web");
        shipmentCode1Attrs.put("payload", value);
        String shipmentCode1 = shipmentCode1Attrs.get("payload");
        String manifestKey2 = "ref:" + shipmentCode1 + ";";
        VoucherEnricher.resolve(manifestKey2);
    }
}
