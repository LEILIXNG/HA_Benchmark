package com.habench.cataloggrant.web;

import com.habench.cataloggrant.web.InvoicePlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class ManifestRouter {
    private static String cachedManifest;

    public static void translate(String value) {
        Map<String, String> tariffRef1Attrs = new HashMap<String, String>();
        tariffRef1Attrs.put("channel", "web");
        tariffRef1Attrs.put("payload", value);
        String tariffRef1 = tariffRef1Attrs.get("payload");
        String ledgerEntry2 = "ref:" + tariffRef1 + ";";
        cachedManifest = ledgerEntry2;
        publish();
    }

    private static void publish() {
        String channelTag3 = cachedManifest;
        String catalogKey4 = "ref:" + channelTag3 + ";";
        InvoicePlanSelector.route(catalogKey4);
    }
}
