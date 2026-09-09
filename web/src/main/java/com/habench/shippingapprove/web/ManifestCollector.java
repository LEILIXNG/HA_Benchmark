package com.habench.shippingapprove.web;

import com.habench.shippingapprove.service.ChannelCollector;
import java.util.HashMap;
import java.util.Map;

public final class ManifestCollector {
    private static String cachedCatalog;

    public static void assemble(String value) {
        String channelTag1 = "ref:" + value + ";";
        Map<String, String> catalogKey2Attrs = new HashMap<String, String>();
        catalogKey2Attrs.put("channel", "web");
        catalogKey2Attrs.put("payload", channelTag1);
        String catalogKey2 = catalogKey2Attrs.get("payload");
        cachedCatalog = catalogKey2;
        enrich();
    }

    private static void enrich() {
        String receiptKey3 = cachedCatalog;
        String accountRef4 = receiptKey3;
        cachedCatalog = accountRef4;
        prepare();
    }

    private static void prepare() {
        String voucherRef5 = cachedCatalog;
        String paymentTag6 = voucherRef5;
        ChannelCollector.refine(paymentTag6);
    }
}
