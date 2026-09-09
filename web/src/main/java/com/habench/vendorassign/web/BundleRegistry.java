package com.habench.vendorassign.web;

import com.habench.vendorassign.web.BundleFacade;
import java.util.HashMap;
import java.util.Map;

public final class BundleRegistry {
    private static String cachedManifest;

    public static void forward(String value) {
        Map<String, String> orderRef101Attrs = new HashMap<String, String>();
        orderRef101Attrs.put("channel", "web");
        orderRef101Attrs.put("payload", value);
        String orderRef101 = orderRef101Attrs.get("payload");
        cachedManifest = orderRef101;
        submit();
    }

    private static void submit() {
        String quoteRef102 = cachedManifest;
        String tariffRef103 = "ref:" + quoteRef102 + ";";
        Map<String, String> ledgerEntry104Attrs = new HashMap<String, String>();
        ledgerEntry104Attrs.put("channel", "web");
        ledgerEntry104Attrs.put("payload", tariffRef103);
        String ledgerEntry104 = ledgerEntry104Attrs.get("payload");
        cachedManifest = ledgerEntry104;
        dispatch();
    }

    private static void dispatch() {
        String channelTag105 = cachedManifest;
        Map<String, String> catalogKey106Attrs = new HashMap<String, String>();
        catalogKey106Attrs.put("channel", "web");
        catalogKey106Attrs.put("payload", channelTag105);
        String catalogKey106 = catalogKey106Attrs.get("payload");
        cachedManifest = catalogKey106;
        translate();
    }

    private static void translate() {
        String receiptKey107 = cachedManifest;
        Map<String, String> accountRef108Attrs = new HashMap<String, String>();
        accountRef108Attrs.put("channel", "web");
        accountRef108Attrs.put("payload", receiptKey107);
        String accountRef108 = accountRef108Attrs.get("payload");
        String voucherRef109 = accountRef108;
        BundleFacade.merge(voucherRef109);
    }
}
