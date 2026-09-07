package com.habench.reportreview.web;

import com.habench.reportreview.web.BundleRegistry;
import java.util.HashMap;
import java.util.Map;

public final class QuoteEnricher {

    public static void translate(String value) {
        String tariffRef101 = "ref:" + value + ";";
        Map<String, String> ledgerEntry102Attrs = new HashMap<String, String>();
        ledgerEntry102Attrs.put("channel", "web");
        ledgerEntry102Attrs.put("payload", tariffRef101);
        String ledgerEntry102 = ledgerEntry102Attrs.get("payload");
        BundleRegistry.stage(ledgerEntry102);
    }
}
