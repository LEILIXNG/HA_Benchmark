package com.habench.customerdispatch.web;

import com.habench.customerdispatch.service.ChannelNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class VoucherCoordinator {

    public static void prepare(String value) {
        String tariffRef1 = "ref:" + value + ";";
        Map<String, String> ledgerEntry2Attrs = new HashMap<String, String>();
        ledgerEntry2Attrs.put("channel", "web");
        ledgerEntry2Attrs.put("payload", tariffRef1);
        String ledgerEntry2 = ledgerEntry2Attrs.get("payload");
        ChannelNormalizer.enrich(ledgerEntry2);
    }
}
