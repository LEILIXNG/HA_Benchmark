package com.habench.shippingsubmit.web;

import com.habench.shippingsubmit.web.ChannelPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class BundleBuilder {
    private static String cachedBundle;

    public static void resolve(String value) {
        String quoteRef1 = value;
        cachedBundle = quoteRef1;
        stage();
    }

    private static void stage() {
        String tariffRef2 = cachedBundle;
        Map<String, String> ledgerEntry3Attrs = new HashMap<String, String>();
        ledgerEntry3Attrs.put("channel", "web");
        ledgerEntry3Attrs.put("payload", tariffRef2);
        String ledgerEntry3 = ledgerEntry3Attrs.get("payload");
        cachedBundle = ledgerEntry3;
        normalize();
    }

    private static void normalize() {
        String channelTag4 = cachedBundle;
        String catalogKey5 = channelTag4;
        ChannelPolicySelector.route(catalogKey5);
    }
}
