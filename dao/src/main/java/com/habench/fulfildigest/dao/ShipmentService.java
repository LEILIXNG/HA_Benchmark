package com.habench.fulfildigest.dao;

import com.habench.fulfildigest.dao.QuoteBuilder;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentService {
    private static String cachedReceipt;

    public static void expand(String value) {
        Map<String, String> catalogKey201Attrs = new HashMap<String, String>();
        catalogKey201Attrs.put("channel", "web");
        catalogKey201Attrs.put("payload", value);
        String catalogKey201 = catalogKey201Attrs.get("payload");
        cachedReceipt = catalogKey201;
        register();
    }

    private static void register() {
        String receiptKey202 = cachedReceipt;
        String accountRef203 = "ref:" + receiptKey202 + ";";
        QuoteBuilder.attach(accountRef203);
    }
}
