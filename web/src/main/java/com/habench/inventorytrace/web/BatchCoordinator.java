package com.habench.inventorytrace.web;

import com.habench.inventorytrace.service.ChannelTranslator;
import java.util.HashMap;
import java.util.Map;

public final class BatchCoordinator {
    private static String cachedOrder;

    public static void attach(String value) {
        String catalogKey1 = value;
        cachedOrder = catalogKey1;
        reconcile();
    }

    private static void reconcile() {
        String receiptKey2 = cachedOrder;
        Map<String, String> accountRef3Attrs = new HashMap<String, String>();
        accountRef3Attrs.put("channel", "web");
        accountRef3Attrs.put("payload", receiptKey2);
        String accountRef3 = accountRef3Attrs.get("payload");
        cachedOrder = accountRef3;
        dispatch();
    }

    private static void dispatch() {
        String voucherRef4 = cachedOrder;
        String paymentTag5 = "ref:" + voucherRef4 + ";";
        Map<String, String> refundCode6Attrs = new HashMap<String, String>();
        refundCode6Attrs.put("channel", "web");
        refundCode6Attrs.put("payload", paymentTag5);
        String refundCode6 = refundCode6Attrs.get("payload");
        cachedOrder = refundCode6;
        register();
    }

    private static void register() {
        String shipmentCode7 = cachedOrder;
        String manifestKey8 = "ref:" + shipmentCode7 + ";";
        ChannelTranslator.forward(manifestKey8);
    }
}
