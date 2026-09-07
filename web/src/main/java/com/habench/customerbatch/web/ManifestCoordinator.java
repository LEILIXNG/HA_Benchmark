package com.habench.customerbatch.web;

import com.habench.customerbatch.web.AccountCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class ManifestCoordinator {
    private static String cachedBatch;

    public static void submit(String value) {
        String channelTag1 = value;
        Map<String, String> catalogKey2Attrs = new HashMap<String, String>();
        catalogKey2Attrs.put("channel", "web");
        catalogKey2Attrs.put("payload", channelTag1);
        String catalogKey2 = catalogKey2Attrs.get("payload");
        cachedBatch = catalogKey2;
        publish();
    }

    private static void publish() {
        String receiptKey3 = cachedBatch;
        String accountRef4 = "ref:" + receiptKey3 + ";";
        String voucherRef5 = accountRef4;
        cachedBatch = voucherRef5;
        forward();
    }

    private static void forward() {
        String paymentTag6 = cachedBatch;
        Map<String, String> refundCode7Attrs = new HashMap<String, String>();
        refundCode7Attrs.put("channel", "web");
        refundCode7Attrs.put("payload", paymentTag6);
        String refundCode7 = refundCode7Attrs.get("payload");
        cachedBatch = refundCode7;
        merge();
    }

    private static void merge() {
        String shipmentCode8 = cachedBatch;
        String manifestKey9 = "ref:" + shipmentCode8 + ";";
        AccountCoordinator.prepare(manifestKey9);
    }
}
