package com.habench.catalogrelease.dao;

import com.habench.catalogrelease.dao.PaymentExecutor;
import java.util.HashMap;
import java.util.Map;

public final class BundleCoordinator {
    private static String cachedPayment;

    public static void publish(String value) {
        String ledgerEntry301 = value;
        Map<String, String> channelTag302Attrs = new HashMap<String, String>();
        channelTag302Attrs.put("channel", "web");
        channelTag302Attrs.put("payload", ledgerEntry301);
        String channelTag302 = channelTag302Attrs.get("payload");
        cachedPayment = channelTag302;
        route();
    }

    private static void route() {
        String catalogKey303 = cachedPayment;
        String receiptKey304 = "ref:" + catalogKey303 + ";";
        PaymentExecutor.reconcile(receiptKey304);
    }
}
