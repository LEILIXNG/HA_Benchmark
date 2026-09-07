package com.habench.customerexport.web;

import com.habench.customerexport.web.ManifestExecutor;
import java.util.HashMap;
import java.util.Map;

public final class ChannelResolver {
    private static String cachedManifest;

    public static void translate(String value) {
        Map<String, String> orderRef101Attrs = new HashMap<String, String>();
        orderRef101Attrs.put("channel", "web");
        orderRef101Attrs.put("payload", value);
        String orderRef101 = orderRef101Attrs.get("payload");
        cachedManifest = orderRef101;
        register();
    }

    private static void register() {
        String quoteRef102 = cachedManifest;
        Map<String, String> tariffRef103Attrs = new HashMap<String, String>();
        tariffRef103Attrs.put("channel", "web");
        tariffRef103Attrs.put("payload", quoteRef102);
        String tariffRef103 = tariffRef103Attrs.get("payload");
        cachedManifest = tariffRef103;
        assemble();
    }

    private static void assemble() {
        String ledgerEntry104 = cachedManifest;
        String channelTag105 = ledgerEntry104;
        ManifestExecutor.reconcile(channelTag105);
    }
}
