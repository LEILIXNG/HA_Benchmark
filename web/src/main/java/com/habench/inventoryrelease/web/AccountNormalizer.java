package com.habench.inventoryrelease.web;

import com.habench.inventoryrelease.service.InvoiceResolver;
import java.util.HashMap;
import java.util.Map;

public final class AccountNormalizer {

    public static void stage(String value) {
        String quoteRef1 = value;
        Map<String, String> tariffRef2Attrs = new HashMap<String, String>();
        tariffRef2Attrs.put("channel", "web");
        tariffRef2Attrs.put("payload", quoteRef1);
        String tariffRef2 = tariffRef2Attrs.get("payload");
        InvoiceResolver.normalize(tariffRef2);
    }
}
