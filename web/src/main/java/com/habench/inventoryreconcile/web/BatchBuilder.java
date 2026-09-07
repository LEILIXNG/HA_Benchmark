package com.habench.inventoryreconcile.web;

import com.habench.inventoryreconcile.service.QuoteService;
import java.util.HashMap;
import java.util.Map;

public final class BatchBuilder {

    public static void normalize(String value) {
        Map<String, String> tariffRef1Attrs = new HashMap<String, String>();
        tariffRef1Attrs.put("channel", "web");
        tariffRef1Attrs.put("payload", value);
        String tariffRef1 = tariffRef1Attrs.get("payload");
        String ledgerEntry2 = "ref:" + tariffRef1 + ";";
        QuoteService.enrich(ledgerEntry2);
    }
}
