package com.habench.shippingclose.service;

import com.habench.shippingclose.dao.CatalogAssembler;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceService {
    private static String cachedQuote;

    public static void stage(String value) {
        String quoteRef401 = "ref:" + value + ";";
        Map<String, String> tariffRef402Attrs = new HashMap<String, String>();
        tariffRef402Attrs.put("channel", "web");
        tariffRef402Attrs.put("payload", quoteRef401);
        String tariffRef402 = tariffRef402Attrs.get("payload");
        cachedQuote = tariffRef402;
        forward();
    }

    private static void forward() {
        String ledgerEntry403 = cachedQuote;
        String channelTag404 = "ref:" + ledgerEntry403 + ";";
        CatalogAssembler.enrich(channelTag404);
    }
}
