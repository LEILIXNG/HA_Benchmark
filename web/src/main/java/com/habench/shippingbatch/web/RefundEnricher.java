package com.habench.shippingbatch.web;

import com.habench.shippingbatch.web.LedgerPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class RefundEnricher {
    private static String cachedCatalog;

    public static void route(String value) {
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("payload", value);
        String orderRef1 = orderRef1Attrs.get("payload");
        Map<String, String> quoteRef2Attrs = new HashMap<String, String>();
        quoteRef2Attrs.put("channel", "web");
        quoteRef2Attrs.put("payload", orderRef1);
        String quoteRef2 = quoteRef2Attrs.get("payload");
        cachedCatalog = quoteRef2;
        publish();
    }

    private static void publish() {
        String tariffRef3 = cachedCatalog;
        Map<String, String> ledgerEntry4Attrs = new HashMap<String, String>();
        ledgerEntry4Attrs.put("channel", "web");
        ledgerEntry4Attrs.put("payload", tariffRef3);
        String ledgerEntry4 = ledgerEntry4Attrs.get("payload");
        String channelTag5 = "ref:" + ledgerEntry4 + ";";
        LedgerPolicySelector.refine(channelTag5);
    }
}
