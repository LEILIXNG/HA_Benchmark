package com.habench.fulfilsettlequeue.dao;

import com.habench.fulfilsettlequeue.dao.SessionPolicy;
import java.util.HashMap;
import java.util.Map;

public final class SessionTranslator {
    private static String cachedCatalog;

    public static void route(String value) {
        Map<String, String> refundCode201Attrs = new HashMap<String, String>();
        refundCode201Attrs.put("channel", "web");
        refundCode201Attrs.put("payload", value);
        String refundCode201 = refundCode201Attrs.get("payload");
        cachedCatalog = refundCode201;
        refine();
    }

    private static void refine() {
        String shipmentCode202 = cachedCatalog;
        Map<String, String> manifestKey203Attrs = new HashMap<String, String>();
        manifestKey203Attrs.put("channel", "web");
        manifestKey203Attrs.put("payload", shipmentCode202);
        String manifestKey203 = manifestKey203Attrs.get("payload");
        Map<String, String> invoiceKey204Attrs = new HashMap<String, String>();
        invoiceKey204Attrs.put("channel", "web");
        invoiceKey204Attrs.put("payload", manifestKey203);
        String invoiceKey204 = invoiceKey204Attrs.get("payload");
        SessionPolicy.assemble(invoiceKey204);
    }
}
