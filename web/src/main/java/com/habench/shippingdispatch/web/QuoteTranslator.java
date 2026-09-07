package com.habench.shippingdispatch.web;

import com.habench.shippingdispatch.service.InvoiceService;
import java.util.HashMap;
import java.util.Map;

public final class QuoteTranslator {
    private static String cachedBundle;

    public static void publish(String value) {
        Map<String, String> manifestKey1Attrs = new HashMap<String, String>();
        manifestKey1Attrs.put("channel", "web");
        manifestKey1Attrs.put("payload", value);
        String manifestKey1 = manifestKey1Attrs.get("payload");
        String invoiceKey2 = "ref:" + manifestKey1 + ";";
        cachedBundle = invoiceKey2;
        forward();
    }

    private static void forward() {
        String batchTag3 = cachedBundle;
        String orderRef4 = "ref:" + batchTag3 + ";";
        String quoteRef5 = "ref:" + orderRef4 + ";";
        cachedBundle = quoteRef5;
        resolve();
    }

    private static void resolve() {
        String tariffRef6 = cachedBundle;
        String ledgerEntry7 = tariffRef6;
        String channelTag8 = ledgerEntry7;
        InvoiceService.attach(channelTag8);
    }
}
