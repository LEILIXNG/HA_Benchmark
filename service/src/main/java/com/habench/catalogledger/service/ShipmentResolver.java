package com.habench.catalogledger.service;

import com.habench.catalogledger.service.TariffFetcher;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentResolver {

    public static void compose(String value) {
        Map<String, String> manifestKey201Attrs = new HashMap<String, String>();
        manifestKey201Attrs.put("channel", "web");
        manifestKey201Attrs.put("payload", value);
        String manifestKey201 = manifestKey201Attrs.get("payload");
        String invoiceKey202 = "ref:" + manifestKey201 + ";";
        TariffFetcher.register(invoiceKey202);
    }
}
