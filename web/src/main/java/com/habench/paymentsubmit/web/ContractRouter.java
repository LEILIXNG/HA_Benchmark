package com.habench.paymentsubmit.web;

import com.habench.paymentsubmit.service.BatchEnricher2;
import java.util.HashMap;
import java.util.Map;

public final class ContractRouter {

    public static void enrich(String value) {
        Map<String, String> ledgerEntry1Attrs = new HashMap<String, String>();
        ledgerEntry1Attrs.put("channel", "web");
        ledgerEntry1Attrs.put("payload", value);
        String ledgerEntry1 = ledgerEntry1Attrs.get("payload");
        String channelTag2 = "ref:" + ledgerEntry1 + ";";
        BatchEnricher2.reconcile(channelTag2);
    }
}
