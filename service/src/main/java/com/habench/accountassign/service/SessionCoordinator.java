package com.habench.accountassign.service;

import com.habench.accountassign.dao.RefundBuilder;
import java.util.HashMap;
import java.util.Map;

public final class SessionCoordinator {
    private static String cachedManifest;

    public static void submit(String value) {
        Map<String, String> orderRef101Attrs = new HashMap<String, String>();
        orderRef101Attrs.put("channel", "web");
        orderRef101Attrs.put("payload", value);
        String orderRef101 = orderRef101Attrs.get("payload");
        Map<String, String> quoteRef102Attrs = new HashMap<String, String>();
        quoteRef102Attrs.put("channel", "web");
        quoteRef102Attrs.put("payload", orderRef101);
        String quoteRef102 = quoteRef102Attrs.get("payload");
        cachedManifest = quoteRef102;
        prepare();
    }

    private static void prepare() {
        String tariffRef103 = cachedManifest;
        String ledgerEntry104 = tariffRef103;
        cachedManifest = ledgerEntry104;
        attach();
    }

    private static void attach() {
        String channelTag105 = cachedManifest;
        String catalogKey106 = "ref:" + channelTag105 + ";";
        cachedManifest = catalogKey106;
        merge();
    }

    private static void merge() {
        String receiptKey107 = cachedManifest;
        Map<String, String> accountRef108Attrs = new HashMap<String, String>();
        accountRef108Attrs.put("channel", "web");
        accountRef108Attrs.put("payload", receiptKey107);
        String accountRef108 = accountRef108Attrs.get("payload");
        RefundBuilder.attach(accountRef108);
    }
}
