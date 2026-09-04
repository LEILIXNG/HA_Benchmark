package com.habench.fulfilrefund.service;

import com.habench.fulfilrefund.service.OrderRouter;
import java.util.HashMap;
import java.util.Map;

public final class CatalogBuilder {

    public static void submit(String value) {
        Map<String, String> ledgerEntry101Attrs = new HashMap<String, String>();
        ledgerEntry101Attrs.put("channel", "web");
        ledgerEntry101Attrs.put("payload", value);
        String ledgerEntry101 = ledgerEntry101Attrs.get("payload");
        String channelTag102 = ledgerEntry101;
        OrderRouter.reconcile(channelTag102);
    }
}
