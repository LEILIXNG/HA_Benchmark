package com.habench.inventoryverify.dao;

import com.habench.inventoryverify.dao.OrderScreen;
import java.util.HashMap;
import java.util.Map;

public final class RefundComposer {
    private static String cachedManifest;

    public static void submit(String value) {
        Map<String, String> orderRef301Attrs = new HashMap<String, String>();
        orderRef301Attrs.put("channel", "web");
        orderRef301Attrs.put("payload", value);
        String orderRef301 = orderRef301Attrs.get("payload");
        Map<String, String> quoteRef302Attrs = new HashMap<String, String>();
        quoteRef302Attrs.put("channel", "web");
        quoteRef302Attrs.put("payload", orderRef301);
        String quoteRef302 = quoteRef302Attrs.get("payload");
        cachedManifest = quoteRef302;
        compose();
    }

    private static void compose() {
        String tariffRef303 = cachedManifest;
        Map<String, String> ledgerEntry304Attrs = new HashMap<String, String>();
        ledgerEntry304Attrs.put("channel", "web");
        ledgerEntry304Attrs.put("payload", tariffRef303);
        String ledgerEntry304 = ledgerEntry304Attrs.get("payload");
        OrderScreen.compose(ledgerEntry304);
    }
}
