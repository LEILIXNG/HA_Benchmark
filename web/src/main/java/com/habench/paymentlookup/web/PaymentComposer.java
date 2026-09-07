package com.habench.paymentlookup.web;

import com.habench.paymentlookup.service.ShipmentComposer;
import java.util.HashMap;
import java.util.Map;

public final class PaymentComposer {
    private static String cachedInvoice;

    public static void route(String value) {
        String channelTag101 = value;
        cachedInvoice = channelTag101;
        translate();
    }

    private static void translate() {
        String catalogKey102 = cachedInvoice;
        Map<String, String> receiptKey103Attrs = new HashMap<String, String>();
        receiptKey103Attrs.put("channel", "web");
        receiptKey103Attrs.put("payload", catalogKey102);
        String receiptKey103 = receiptKey103Attrs.get("payload");
        ShipmentComposer.merge(receiptKey103);
    }
}
