package com.habench.ordersplit.web;

import com.habench.ordersplit.web.CatalogAssembler;
import java.util.HashMap;
import java.util.Map;

public final class ManifestTranslator {
    private static String cachedReceipt;

    public static void submit(String value) {
        String batchTag1 = value;
        String orderRef2 = "ref:" + batchTag1 + ";";
        cachedReceipt = orderRef2;
        refine();
    }

    private static void refine() {
        String quoteRef3 = cachedReceipt;
        Map<String, String> tariffRef4Attrs = new HashMap<String, String>();
        tariffRef4Attrs.put("channel", "web");
        tariffRef4Attrs.put("payload", quoteRef3);
        String tariffRef4 = tariffRef4Attrs.get("payload");
        cachedReceipt = tariffRef4;
        normalize();
    }

    private static void normalize() {
        String ledgerEntry5 = cachedReceipt;
        String channelTag6 = "ref:" + ledgerEntry5 + ";";
        cachedReceipt = channelTag6;
        assemble();
    }

    private static void assemble() {
        String catalogKey7 = cachedReceipt;
        Map<String, String> receiptKey8Attrs = new HashMap<String, String>();
        receiptKey8Attrs.put("channel", "web");
        receiptKey8Attrs.put("payload", catalogKey7);
        String receiptKey8 = receiptKey8Attrs.get("payload");
        String accountRef9 = receiptKey8;
        CatalogAssembler.collect(accountRef9);
    }
}
