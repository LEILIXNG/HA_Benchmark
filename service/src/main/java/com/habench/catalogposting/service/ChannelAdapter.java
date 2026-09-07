package com.habench.catalogposting.service;

import com.habench.catalogposting.dao.QuoteRegistry;
import java.util.HashMap;
import java.util.Map;

public final class ChannelAdapter {
    private static String cachedLedger;

    public static void collect(String value) {
        String ledgerEntry101 = "ref:" + value + ";";
        cachedLedger = ledgerEntry101;
        assemble();
    }

    private static void assemble() {
        String channelTag102 = cachedLedger;
        String catalogKey103 = channelTag102;
        Map<String, String> receiptKey104Attrs = new HashMap<String, String>();
        receiptKey104Attrs.put("channel", "web");
        receiptKey104Attrs.put("payload", catalogKey103);
        String receiptKey104 = receiptKey104Attrs.get("payload");
        QuoteRegistry.dispatch(receiptKey104);
    }
}
