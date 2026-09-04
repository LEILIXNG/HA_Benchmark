package com.habench.billingdraft.web;

import com.habench.billingdraft.web.ManifestValidator;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentBroker {
    private static String cachedChannel;

    public static void publish(String value) {
        Map<String, String> channelTag1Attrs = new HashMap<String, String>();
        channelTag1Attrs.put("channel", "web");
        channelTag1Attrs.put("payload", value);
        String channelTag1 = channelTag1Attrs.get("payload");
        cachedChannel = channelTag1;
        collect();
    }

    private static void collect() {
        String catalogKey2 = cachedChannel;
        String receiptKey3 = "ref:" + catalogKey2 + ";";
        Map<String, String> accountRef4Attrs = new HashMap<String, String>();
        accountRef4Attrs.put("channel", "web");
        accountRef4Attrs.put("payload", receiptKey3);
        String accountRef4 = accountRef4Attrs.get("payload");
        cachedChannel = accountRef4;
        compose();
    }

    private static void compose() {
        String voucherRef5 = cachedChannel;
        String paymentTag6 = "ref:" + voucherRef5 + ";";
        ManifestValidator.attach(paymentTag6);
    }
}
