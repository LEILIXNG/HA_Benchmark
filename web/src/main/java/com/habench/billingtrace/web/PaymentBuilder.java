package com.habench.billingtrace.web;

import com.habench.billingtrace.service.PaymentFacade;
import java.util.HashMap;
import java.util.Map;

public final class PaymentBuilder {
    private static String cachedBundle;

    public static void compose(String value) {
        Map<String, String> ledgerEntry1Attrs = new HashMap<String, String>();
        ledgerEntry1Attrs.put("channel", "web");
        ledgerEntry1Attrs.put("payload", value);
        String ledgerEntry1 = ledgerEntry1Attrs.get("payload");
        Map<String, String> channelTag2Attrs = new HashMap<String, String>();
        channelTag2Attrs.put("channel", "web");
        channelTag2Attrs.put("payload", ledgerEntry1);
        String channelTag2 = channelTag2Attrs.get("payload");
        cachedBundle = channelTag2;
        attach();
    }

    private static void attach() {
        String catalogKey3 = cachedBundle;
        String receiptKey4 = "ref:" + catalogKey3 + ";";
        PaymentFacade.collect(receiptKey4);
    }
}
