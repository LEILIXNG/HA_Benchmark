package com.habench.vendorapprove.service;

import com.habench.vendorapprove.dao.ChannelBuilder;
import java.util.HashMap;
import java.util.Map;

public final class TariffNormalizer {
    private static String cachedReceipt;

    public static void merge(String value) {
        Map<String, String> manifestKey101Attrs = new HashMap<String, String>();
        manifestKey101Attrs.put("channel", "web");
        manifestKey101Attrs.put("payload", value);
        String manifestKey101 = manifestKey101Attrs.get("payload");
        String invoiceKey102 = manifestKey101;
        cachedReceipt = invoiceKey102;
        collect();
    }

    private static void collect() {
        String batchTag103 = cachedReceipt;
        String orderRef104 = "ref:" + batchTag103 + ";";
        cachedReceipt = orderRef104;
        enrich();
    }

    private static void enrich() {
        String quoteRef105 = cachedReceipt;
        String tariffRef106 = quoteRef105;
        Map<String, String> ledgerEntry107Attrs = new HashMap<String, String>();
        ledgerEntry107Attrs.put("channel", "web");
        ledgerEntry107Attrs.put("payload", tariffRef106);
        String ledgerEntry107 = ledgerEntry107Attrs.get("payload");
        ChannelBuilder.compose(ledgerEntry107);
    }
}
