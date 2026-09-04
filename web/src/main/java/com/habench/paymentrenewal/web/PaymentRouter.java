package com.habench.paymentrenewal.web;

import com.habench.paymentrenewal.web.ContractRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class PaymentRouter {
    private static String cachedVoucher;

    public static void collect(String value) {
        String tariffRef1 = value;
        cachedVoucher = tariffRef1;
        assemble();
    }

    private static void assemble() {
        String ledgerEntry2 = cachedVoucher;
        Map<String, String> channelTag3Attrs = new HashMap<String, String>();
        channelTag3Attrs.put("channel", "web");
        channelTag3Attrs.put("payload", ledgerEntry2);
        String channelTag3 = channelTag3Attrs.get("payload");
        Map<String, String> catalogKey4Attrs = new HashMap<String, String>();
        catalogKey4Attrs.put("channel", "web");
        catalogKey4Attrs.put("payload", channelTag3);
        String catalogKey4 = catalogKey4Attrs.get("payload");
        ContractRuleSelector.assemble(catalogKey4);
    }
}
