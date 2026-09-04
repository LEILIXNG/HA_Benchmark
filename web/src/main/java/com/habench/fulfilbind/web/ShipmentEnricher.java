package com.habench.fulfilbind.web;

import com.habench.fulfilbind.service.AccountCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentEnricher {
    private static String cachedLedger;

    public static void resolve(String value) {
        Map<String, String> manifestKey201Attrs = new HashMap<String, String>();
        manifestKey201Attrs.put("channel", "web");
        manifestKey201Attrs.put("payload", value);
        String manifestKey201 = manifestKey201Attrs.get("payload");
        String invoiceKey202 = manifestKey201;
        cachedLedger = invoiceKey202;
        expand();
    }

    private static void expand() {
        String batchTag203 = cachedLedger;
        Map<String, String> orderRef204Attrs = new HashMap<String, String>();
        orderRef204Attrs.put("channel", "web");
        orderRef204Attrs.put("payload", batchTag203);
        String orderRef204 = orderRef204Attrs.get("payload");
        Map<String, String> quoteRef205Attrs = new HashMap<String, String>();
        quoteRef205Attrs.put("channel", "web");
        quoteRef205Attrs.put("payload", orderRef204);
        String quoteRef205 = quoteRef205Attrs.get("payload");
        AccountCoordinator.normalize(quoteRef205);
    }
}
