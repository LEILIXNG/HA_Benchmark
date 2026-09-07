package com.habench.shippingbatch.service;

import com.habench.shippingbatch.dao.LedgerCollector;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceEnricher {

    public static void register(String value) {
        Map<String, String> orderRef301Attrs = new HashMap<String, String>();
        orderRef301Attrs.put("channel", "web");
        orderRef301Attrs.put("payload", value);
        String orderRef301 = orderRef301Attrs.get("payload");
        Map<String, String> quoteRef302Attrs = new HashMap<String, String>();
        quoteRef302Attrs.put("channel", "web");
        quoteRef302Attrs.put("payload", orderRef301);
        String quoteRef302 = quoteRef302Attrs.get("payload");
        LedgerCollector.enrich(quoteRef302);
    }
}
