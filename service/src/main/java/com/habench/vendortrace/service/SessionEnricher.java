package com.habench.vendortrace.service;

import com.habench.vendortrace.service.InvoiceFetcher;
import java.util.HashMap;
import java.util.Map;

public final class SessionEnricher {

    public static void prepare(String value) {
        Map<String, String> quoteRef201Attrs = new HashMap<String, String>();
        quoteRef201Attrs.put("channel", "web");
        quoteRef201Attrs.put("payload", value);
        String quoteRef201 = quoteRef201Attrs.get("payload");
        String tariffRef202 = "ref:" + quoteRef201 + ";";
        InvoiceFetcher.merge(tariffRef202);
    }
}
