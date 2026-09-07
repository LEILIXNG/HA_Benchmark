package com.habench.fulfilissue.dao;

import com.habench.fulfilissue.dao.RefundValidator;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceResolver {

    public static void translate(String value) {
        String invoiceKey301 = value;
        Map<String, String> batchTag302Attrs = new HashMap<String, String>();
        batchTag302Attrs.put("channel", "web");
        batchTag302Attrs.put("payload", invoiceKey301);
        String batchTag302 = batchTag302Attrs.get("payload");
        RefundValidator.stage(batchTag302);
    }
}
