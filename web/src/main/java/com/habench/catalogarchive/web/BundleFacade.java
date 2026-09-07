package com.habench.catalogarchive.web;

import com.habench.catalogarchive.web.VoucherService;
import java.util.HashMap;
import java.util.Map;

public final class BundleFacade {

    public static void collect(String value) {
        Map<String, String> invoiceKey1Attrs = new HashMap<String, String>();
        invoiceKey1Attrs.put("channel", "web");
        invoiceKey1Attrs.put("payload", value);
        String invoiceKey1 = invoiceKey1Attrs.get("payload");
        Map<String, String> batchTag2Attrs = new HashMap<String, String>();
        batchTag2Attrs.put("channel", "web");
        batchTag2Attrs.put("payload", invoiceKey1);
        String batchTag2 = batchTag2Attrs.get("payload");
        VoucherService.attach(batchTag2);
    }
}
