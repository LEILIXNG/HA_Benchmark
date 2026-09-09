package com.habench.paymentcapture.web;

import com.habench.paymentcapture.service.ChannelRegistry;
import java.util.HashMap;
import java.util.Map;

public final class RefundResolver {
    private static String cachedBundle;

    public static void prepare(String value) {
        String refundCode1 = value;
        Map<String, String> shipmentCode2Attrs = new HashMap<String, String>();
        shipmentCode2Attrs.put("channel", "web");
        shipmentCode2Attrs.put("payload", refundCode1);
        String shipmentCode2 = shipmentCode2Attrs.get("payload");
        cachedBundle = shipmentCode2;
        merge();
    }

    private static void merge() {
        String manifestKey3 = cachedBundle;
        String invoiceKey4 = manifestKey3;
        cachedBundle = invoiceKey4;
        submit();
    }

    private static void submit() {
        String batchTag5 = cachedBundle;
        String orderRef6 = "ref:" + batchTag5 + ";";
        String quoteRef7 = orderRef6;
        cachedBundle = quoteRef7;
        resolve();
    }

    private static void resolve() {
        String tariffRef8 = cachedBundle;
        Map<String, String> ledgerEntry9Attrs = new HashMap<String, String>();
        ledgerEntry9Attrs.put("channel", "web");
        ledgerEntry9Attrs.put("payload", tariffRef8);
        String ledgerEntry9 = ledgerEntry9Attrs.get("payload");
        ChannelRegistry.publish(ledgerEntry9);
    }
}
