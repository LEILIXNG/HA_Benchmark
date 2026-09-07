package com.habench.orderreopen.service;

import com.habench.orderreopen.service.LedgerFetcher;
import java.util.HashMap;
import java.util.Map;

public final class AccountNormalizer {
    private static String cachedLedger;

    public static void merge(String value) {
        String quoteRef201 = "ref:" + value + ";";
        cachedLedger = quoteRef201;
        collect();
    }

    private static void collect() {
        String tariffRef202 = cachedLedger;
        String ledgerEntry203 = tariffRef202;
        Map<String, String> channelTag204Attrs = new HashMap<String, String>();
        channelTag204Attrs.put("channel", "web");
        channelTag204Attrs.put("payload", ledgerEntry203);
        String channelTag204 = channelTag204Attrs.get("payload");
        LedgerFetcher.expand(channelTag204);
    }
}
