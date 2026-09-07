package com.habench.customermerge.service;

import com.habench.customermerge.service.PaymentGuard;
import java.util.HashMap;
import java.util.Map;

public final class CatalogFacade {

    public static void collect(String value) {
        Map<String, String> manifestKey201Attrs = new HashMap<String, String>();
        manifestKey201Attrs.put("channel", "web");
        manifestKey201Attrs.put("payload", value);
        String manifestKey201 = manifestKey201Attrs.get("payload");
        String invoiceKey202 = "ref:" + manifestKey201 + ";";
        PaymentGuard.stage(invoiceKey202);
    }
}
