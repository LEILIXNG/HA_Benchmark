package com.habench.shippingexport.web;

import com.habench.shippingexport.web.ManifestComposer;
import java.util.HashMap;
import java.util.Map;

public final class BundleTranslator {

    public static void expand(String value) {
        String ledgerEntry1 = "ref:" + value + ";";
        Map<String, String> channelTag2Attrs = new HashMap<String, String>();
        channelTag2Attrs.put("channel", "web");
        channelTag2Attrs.put("payload", ledgerEntry1);
        String channelTag2 = channelTag2Attrs.get("payload");
        ManifestComposer.enrich(channelTag2);
    }
}
