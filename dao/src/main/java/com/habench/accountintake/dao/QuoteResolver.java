package com.habench.accountintake.dao;

import com.habench.accountintake.dao.AccountPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class QuoteResolver {
    private static String cachedChannel;

    public static void enrich(String value) {
        String orderRef201 = "ref:" + value + ";";
        String quoteRef202 = orderRef201;
        cachedChannel = quoteRef202;
        translate();
    }

    private static void translate() {
        String tariffRef203 = cachedChannel;
        Map<String, String> ledgerEntry204Attrs = new HashMap<String, String>();
        ledgerEntry204Attrs.put("channel", "web");
        ledgerEntry204Attrs.put("payload", tariffRef203);
        String ledgerEntry204 = ledgerEntry204Attrs.get("payload");
        AccountPolicySelector.prepare(ledgerEntry204);
    }
}
