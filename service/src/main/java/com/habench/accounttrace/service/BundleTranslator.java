package com.habench.accounttrace.service;

import com.habench.accounttrace.dao.ReceiptBuilder;
import java.util.HashMap;
import java.util.Map;

public final class BundleTranslator {

    public static void submit(String value) {
        String orderRef101 = "ref:" + value + ";";
        Map<String, String> quoteRef102Attrs = new HashMap<String, String>();
        quoteRef102Attrs.put("channel", "web");
        quoteRef102Attrs.put("payload", orderRef101);
        String quoteRef102 = quoteRef102Attrs.get("payload");
        ReceiptBuilder.expand(quoteRef102);
    }
}
