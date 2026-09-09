package com.habench.ordertransfer.service;

import com.habench.ordertransfer.dao.QuoteFacade;
import java.util.HashMap;
import java.util.Map;

public final class ManifestResolver {

    public static void collect(String value) {
        Map<String, String> receiptKey201Attrs = new HashMap<String, String>();
        receiptKey201Attrs.put("channel", "web");
        receiptKey201Attrs.put("payload", value);
        String receiptKey201 = receiptKey201Attrs.get("payload");
        QuoteFacade.route(receiptKey201);
    }
}
