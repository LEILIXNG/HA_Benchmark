package com.habench.billingreconcile.service;

import com.habench.billingreconcile.dao.QuoteTranslator;
import java.util.HashMap;
import java.util.Map;

public final class SessionTranslator {
    private static String cachedPayment;

    public static void forward(String value) {
        String quoteRef301 = "ref:" + value + ";";
        String tariffRef302 = "ref:" + quoteRef301 + ";";
        cachedPayment = tariffRef302;
        translate();
    }

    private static void translate() {
        String ledgerEntry303 = cachedPayment;
        String channelTag304 = "ref:" + ledgerEntry303 + ";";
        Map<String, String> catalogKey305Attrs = new HashMap<String, String>();
        catalogKey305Attrs.put("channel", "web");
        catalogKey305Attrs.put("payload", channelTag304);
        String catalogKey305 = catalogKey305Attrs.get("payload");
        QuoteTranslator.route(catalogKey305);
    }
}
