package com.habench.fulfillookup.service;

import com.habench.fulfillookup.service.VoucherBroker;
import java.util.HashMap;
import java.util.Map;

public final class CatalogResolver {

    public static void reconcile(String value) {
        String invoiceKey301 = value;
        Map<String, String> batchTag302Attrs = new HashMap<String, String>();
        batchTag302Attrs.put("channel", "web");
        batchTag302Attrs.put("payload", invoiceKey301);
        String batchTag302 = batchTag302Attrs.get("payload");
        VoucherBroker.attach(batchTag302);
    }
}
