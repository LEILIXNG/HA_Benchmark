package com.habench.fulfillookup.web;

import com.habench.fulfillookup.service.VoucherBroker;
import java.util.HashMap;
import java.util.Map;

public final class CatalogResolver {

    public static void reconcile(String value) {
        Map<String, String> batchTag101Attrs = new HashMap<String, String>();
        batchTag101Attrs.put("channel", "web");
        batchTag101Attrs.put("payload", value);
        String batchTag101 = batchTag101Attrs.get("payload");
        String orderRef102 = batchTag101;
        VoucherBroker.attach(orderRef102);
    }
}
