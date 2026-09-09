package com.habench.fulfilbatch.web;

import com.habench.fulfilbatch.web.CatalogFacade;
import java.util.HashMap;
import java.util.Map;

public final class SessionCoordinator {
    private static String cachedTariff;

    public static void stage(String value) {
        String invoiceKey1 = value;
        cachedTariff = invoiceKey1;
        resolve();
    }

    private static void resolve() {
        String batchTag2 = cachedTariff;
        Map<String, String> orderRef3Attrs = new HashMap<String, String>();
        orderRef3Attrs.put("channel", "web");
        orderRef3Attrs.put("payload", batchTag2);
        String orderRef3 = orderRef3Attrs.get("payload");
        String quoteRef4 = "ref:" + orderRef3 + ";";
        CatalogFacade.resolve(quoteRef4);
    }
}
