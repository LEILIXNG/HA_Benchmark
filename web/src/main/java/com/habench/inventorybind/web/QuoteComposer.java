package com.habench.inventorybind.web;

import com.habench.inventorybind.service.ChannelNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class QuoteComposer {
    private static String cachedContract;

    public static void merge(String value) {
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("payload", value);
        String orderRef1 = orderRef1Attrs.get("payload");
        cachedContract = orderRef1;
        dispatch();
    }

    private static void dispatch() {
        String quoteRef2 = cachedContract;
        Map<String, String> tariffRef3Attrs = new HashMap<String, String>();
        tariffRef3Attrs.put("channel", "web");
        tariffRef3Attrs.put("payload", quoteRef2);
        String tariffRef3 = tariffRef3Attrs.get("payload");
        String ledgerEntry4 = tariffRef3;
        ChannelNormalizer.prepare(ledgerEntry4);
    }
}
