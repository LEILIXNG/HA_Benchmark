package com.habench.catalogmanifest.service;

import com.habench.catalogmanifest.service.BatchValidator;
import java.util.HashMap;
import java.util.Map;

public final class VoucherAssembler {

    public static void normalize(String value) {
        String invoiceKey201 = value;
        Map<String, String> batchTag202Attrs = new HashMap<String, String>();
        batchTag202Attrs.put("channel", "web");
        batchTag202Attrs.put("payload", invoiceKey201);
        String batchTag202 = batchTag202Attrs.get("payload");
        BatchValidator.expand(batchTag202);
    }
}
