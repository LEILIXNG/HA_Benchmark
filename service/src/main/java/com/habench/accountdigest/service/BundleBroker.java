package com.habench.accountdigest.service;

import com.habench.accountdigest.service.ManifestScreen;
import java.util.HashMap;
import java.util.Map;

public final class BundleBroker {
    private static String cachedPayment;

    public static void enrich(String value) {
        Map<String, String> tariffRef301Attrs = new HashMap<String, String>();
        tariffRef301Attrs.put("channel", "web");
        tariffRef301Attrs.put("payload", value);
        String tariffRef301 = tariffRef301Attrs.get("payload");
        cachedPayment = tariffRef301;
        collect();
    }

    private static void collect() {
        String ledgerEntry302 = cachedPayment;
        Map<String, String> channelTag303Attrs = new HashMap<String, String>();
        channelTag303Attrs.put("channel", "web");
        channelTag303Attrs.put("payload", ledgerEntry302);
        String channelTag303 = channelTag303Attrs.get("payload");
        ManifestScreen.refine(channelTag303);
    }
}
