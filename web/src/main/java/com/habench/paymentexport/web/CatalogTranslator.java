package com.habench.paymentexport.web;

import com.habench.paymentexport.service.ShipmentBroker;
import java.util.HashMap;
import java.util.Map;

public final class CatalogTranslator {

    public static void register(String value) {
        Map<String, String> catalogKey1Attrs = new HashMap<String, String>();
        catalogKey1Attrs.put("channel", "web");
        catalogKey1Attrs.put("payload", value);
        String catalogKey1 = catalogKey1Attrs.get("payload");
        String receiptKey2 = "ref:" + catalogKey1 + ";";
        ShipmentBroker.resolve(receiptKey2);
    }
}
