package com.habench.billingmanifest.web;

import com.habench.billingmanifest.web.QuoteBroker;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentTranslator {
    private static String cachedChannel;

    public static void forward(String value) {
        String ledgerEntry1 = "ref:" + value + ";";
        Map<String, String> channelTag2Attrs = new HashMap<String, String>();
        channelTag2Attrs.put("channel", "web");
        channelTag2Attrs.put("payload", ledgerEntry1);
        String channelTag2 = channelTag2Attrs.get("payload");
        cachedChannel = channelTag2;
        attach();
    }

    private static void attach() {
        String catalogKey3 = cachedChannel;
        String receiptKey4 = "ref:" + catalogKey3 + ";";
        Map<String, String> accountRef5Attrs = new HashMap<String, String>();
        accountRef5Attrs.put("channel", "web");
        accountRef5Attrs.put("payload", receiptKey4);
        String accountRef5 = accountRef5Attrs.get("payload");
        cachedChannel = accountRef5;
        enrich();
    }

    private static void enrich() {
        String voucherRef6 = cachedChannel;
        String paymentTag7 = voucherRef6;
        String refundCode8 = paymentTag7;
        QuoteBroker.submit(refundCode8);
    }
}
