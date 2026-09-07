package com.habench.shippingsubmit.web;

import com.habench.shippingsubmit.service.LedgerRouter;
import java.util.HashMap;
import java.util.Map;

public final class OrderBuilder {
    private static String cachedBundle;

    public static void enrich(String value) {
        Map<String, String> quoteRef301Attrs = new HashMap<String, String>();
        quoteRef301Attrs.put("channel", "web");
        quoteRef301Attrs.put("payload", value);
        String quoteRef301 = quoteRef301Attrs.get("payload");
        cachedBundle = quoteRef301;
        compose();
    }

    private static void compose() {
        String tariffRef302 = cachedBundle;
        String ledgerEntry303 = "ref:" + tariffRef302 + ";";
        cachedBundle = ledgerEntry303;
        submit();
    }

    private static void submit() {
        String channelTag304 = cachedBundle;
        String catalogKey305 = "ref:" + channelTag304 + ";";
        String receiptKey306 = "ref:" + catalogKey305 + ";";
        LedgerRouter.expand(receiptKey306);
    }
}
