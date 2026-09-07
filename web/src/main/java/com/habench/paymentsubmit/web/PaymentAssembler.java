package com.habench.paymentsubmit.web;

import com.habench.paymentsubmit.service.PaymentBuilder;
import java.util.HashMap;
import java.util.Map;

public final class PaymentAssembler {

    public static void enrich(String value) {
        Map<String, String> manifestKey1Attrs = new HashMap<String, String>();
        manifestKey1Attrs.put("channel", "web");
        manifestKey1Attrs.put("payload", value);
        String manifestKey1 = manifestKey1Attrs.get("payload");
        String invoiceKey2 = "ref:" + manifestKey1 + ";";
        PaymentBuilder.prepare(invoiceKey2);
    }
}
