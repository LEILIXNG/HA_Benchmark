package com.habench.accountrollup.service;

import com.habench.accountrollup.service.ContractEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class BundleAdapter {
    private static String cachedContract;

    public static void submit(String value) {
        Map<String, String> invoiceKey101Attrs = new HashMap<String, String>();
        invoiceKey101Attrs.put("channel", "web");
        invoiceKey101Attrs.put("payload", value);
        String invoiceKey101 = invoiceKey101Attrs.get("payload");
        Map<String, String> batchTag102Attrs = new HashMap<String, String>();
        batchTag102Attrs.put("channel", "web");
        batchTag102Attrs.put("payload", invoiceKey101);
        String batchTag102 = batchTag102Attrs.get("payload");
        cachedContract = batchTag102;
        stage();
    }

    private static void stage() {
        String orderRef103 = cachedContract;
        String quoteRef104 = orderRef103;
        cachedContract = quoteRef104;
        register();
    }

    private static void register() {
        String tariffRef105 = cachedContract;
        Map<String, String> ledgerEntry106Attrs = new HashMap<String, String>();
        ledgerEntry106Attrs.put("channel", "web");
        ledgerEntry106Attrs.put("payload", tariffRef105);
        String ledgerEntry106 = ledgerEntry106Attrs.get("payload");
        String channelTag107 = ledgerEntry106;
        ContractEvaluator.collect(channelTag107);
    }
}
