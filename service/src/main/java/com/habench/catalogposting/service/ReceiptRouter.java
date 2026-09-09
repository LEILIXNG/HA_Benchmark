package com.habench.catalogposting.service;

import com.habench.catalogposting.service.AccountLoader;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptRouter {

    public static void prepare(String value) {
        Map<String, String> quoteRef201Attrs = new HashMap<String, String>();
        quoteRef201Attrs.put("channel", "web");
        quoteRef201Attrs.put("payload", value);
        String quoteRef201 = quoteRef201Attrs.get("payload");
        AccountLoader.route(quoteRef201);
    }
}
