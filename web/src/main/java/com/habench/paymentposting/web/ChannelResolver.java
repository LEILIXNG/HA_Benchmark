package com.habench.paymentposting.web;

import com.habench.paymentposting.service.ReceiptService;
import java.util.HashMap;
import java.util.Map;

public final class ChannelResolver {

    public static void collect(String value) {
        Map<String, String> manifestKey1Attrs = new HashMap<String, String>();
        manifestKey1Attrs.put("channel", "web");
        manifestKey1Attrs.put("payload", value);
        String manifestKey1 = manifestKey1Attrs.get("payload");
        String invoiceKey2 = "ref:" + manifestKey1 + ";";
        ReceiptService.route(invoiceKey2);
    }
}
