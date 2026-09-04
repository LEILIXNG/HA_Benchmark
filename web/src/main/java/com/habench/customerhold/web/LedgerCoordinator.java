package com.habench.customerhold.web;

import com.habench.customerhold.web.SessionCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class LedgerCoordinator {
    private static String cachedQuote;

    public static void attach(String value) {
        String shipmentCode1 = "ref:" + value + ";";
        Map<String, String> manifestKey2Attrs = new HashMap<String, String>();
        manifestKey2Attrs.put("channel", "web");
        manifestKey2Attrs.put("payload", shipmentCode1);
        String manifestKey2 = manifestKey2Attrs.get("payload");
        cachedQuote = manifestKey2;
        compose();
    }

    private static void compose() {
        String invoiceKey3 = cachedQuote;
        String batchTag4 = invoiceKey3;
        SessionCoordinator.reconcile(batchTag4);
    }
}
