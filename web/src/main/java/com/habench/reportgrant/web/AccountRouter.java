package com.habench.reportgrant.web;

import com.habench.reportgrant.web.BundleStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class AccountRouter {
    private static String cachedOrder;

    public static void reconcile(String value) {
        Map<String, String> quoteRef1Attrs = new HashMap<String, String>();
        quoteRef1Attrs.put("channel", "web");
        quoteRef1Attrs.put("payload", value);
        String quoteRef1 = quoteRef1Attrs.get("payload");
        Map<String, String> tariffRef2Attrs = new HashMap<String, String>();
        tariffRef2Attrs.put("channel", "web");
        tariffRef2Attrs.put("payload", quoteRef1);
        String tariffRef2 = tariffRef2Attrs.get("payload");
        cachedOrder = tariffRef2;
        translate();
    }

    private static void translate() {
        String ledgerEntry3 = cachedOrder;
        String channelTag4 = "ref:" + ledgerEntry3 + ";";
        BundleStrategySelector.collect(channelTag4);
    }
}
