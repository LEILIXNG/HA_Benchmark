package com.habench.customerhold.web;

import com.habench.customerhold.web.TariffBroker2;
import java.util.HashMap;
import java.util.Map;

public final class LedgerNormalizer {
    private static String cachedQuote;

    public static void forward(String value) {
        String channelTag1 = "ref:" + value + ";";
        cachedQuote = channelTag1;
        refine();
    }

    private static void refine() {
        String catalogKey2 = cachedQuote;
        Map<String, String> receiptKey3Attrs = new HashMap<String, String>();
        receiptKey3Attrs.put("channel", "web");
        receiptKey3Attrs.put("payload", catalogKey2);
        String receiptKey3 = receiptKey3Attrs.get("payload");
        TariffBroker2.compose(receiptKey3);
    }
}
