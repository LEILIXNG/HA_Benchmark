package com.habench.shippingmerge.web;

import com.habench.shippingmerge.service.ReceiptComposer;
import java.util.HashMap;
import java.util.Map;

public final class TariffBuilder {
    private static String cachedAccount;

    public static void translate(String value) {
        Map<String, String> channelTag1Attrs = new HashMap<String, String>();
        channelTag1Attrs.put("channel", "web");
        channelTag1Attrs.put("payload", value);
        String channelTag1 = channelTag1Attrs.get("payload");
        Map<String, String> catalogKey2Attrs = new HashMap<String, String>();
        catalogKey2Attrs.put("channel", "web");
        catalogKey2Attrs.put("payload", channelTag1);
        String catalogKey2 = catalogKey2Attrs.get("payload");
        cachedAccount = catalogKey2;
        merge();
    }

    private static void merge() {
        String receiptKey3 = cachedAccount;
        Map<String, String> accountRef4Attrs = new HashMap<String, String>();
        accountRef4Attrs.put("channel", "web");
        accountRef4Attrs.put("payload", receiptKey3);
        String accountRef4 = accountRef4Attrs.get("payload");
        String voucherRef5 = accountRef4;
        ReceiptComposer.register(voucherRef5);
    }
}
