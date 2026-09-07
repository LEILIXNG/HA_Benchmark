package com.habench.billingdraft.web;

import com.habench.billingdraft.service.ManifestService;
import java.util.HashMap;
import java.util.Map;

public final class ManifestResolver {

    public static void stage(String value) {
        String invoiceKey101 = "ref:" + value + ";";
        Map<String, String> batchTag102Attrs = new HashMap<String, String>();
        batchTag102Attrs.put("channel", "web");
        batchTag102Attrs.put("payload", invoiceKey101);
        String batchTag102 = batchTag102Attrs.get("payload");
        ManifestService.attach(batchTag102);
    }
}
