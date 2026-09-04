package com.habench.accountverify.web;

import com.habench.accountverify.service.ShipmentBroker;
import java.util.HashMap;
import java.util.Map;

public final class ChannelCollector {
    private static String cachedBundle;

    public static void dispatch(String value) {
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("payload", value);
        String orderRef1 = orderRef1Attrs.get("payload");
        cachedBundle = orderRef1;
        register();
    }

    private static void register() {
        String quoteRef2 = cachedBundle;
        String tariffRef3 = quoteRef2;
        String ledgerEntry4 = tariffRef3;
        cachedBundle = ledgerEntry4;
        refine();
    }

    private static void refine() {
        String channelTag5 = cachedBundle;
        Map<String, String> catalogKey6Attrs = new HashMap<String, String>();
        catalogKey6Attrs.put("channel", "web");
        catalogKey6Attrs.put("payload", channelTag5);
        String catalogKey6 = catalogKey6Attrs.get("payload");
        Map<String, String> receiptKey7Attrs = new HashMap<String, String>();
        receiptKey7Attrs.put("channel", "web");
        receiptKey7Attrs.put("payload", catalogKey6);
        String receiptKey7 = receiptKey7Attrs.get("payload");
        ShipmentBroker.normalize(receiptKey7);
    }
}
