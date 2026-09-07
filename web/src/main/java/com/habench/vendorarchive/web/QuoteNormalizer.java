package com.habench.vendorarchive.web;

import com.habench.vendorarchive.web.QuoteGuard;
import java.util.HashMap;
import java.util.Map;

public final class QuoteNormalizer {

    public static void dispatch(String value) {
        String quoteRef101 = value;
        Map<String, String> tariffRef102Attrs = new HashMap<String, String>();
        tariffRef102Attrs.put("channel", "web");
        tariffRef102Attrs.put("payload", quoteRef101);
        String tariffRef102 = tariffRef102Attrs.get("payload");
        QuoteGuard.register(tariffRef102);
    }
}
