package com.habench.inventorymanifest.web;

import com.habench.inventorymanifest.service.LedgerCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class PaymentResolver {
    private static String cachedManifest;

    public static void prepare(String value) {
        String channelTag1 = value;
        cachedManifest = channelTag1;
        refine();
    }

    private static void refine() {
        String catalogKey2 = cachedManifest;
        Map<String, String> receiptKey3Attrs = new HashMap<String, String>();
        receiptKey3Attrs.put("channel", "web");
        receiptKey3Attrs.put("payload", catalogKey2);
        String receiptKey3 = receiptKey3Attrs.get("payload");
        String accountRef4 = receiptKey3;
        cachedManifest = accountRef4;
        reconcile();
    }

    private static void reconcile() {
        String voucherRef5 = cachedManifest;
        String paymentTag6 = "ref:" + voucherRef5 + ";";
        String refundCode7 = "ref:" + paymentTag6 + ";";
        LedgerCoordinator.translate(refundCode7);
    }
}
