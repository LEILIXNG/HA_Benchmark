package com.habench.fulfilledger.service;

import com.habench.fulfilledger.service.PaymentFetcher;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceResolver {
    private static String cachedPayment;

    public static void translate(String value) {
        String refundCode201 = value;
        Map<String, String> shipmentCode202Attrs = new HashMap<String, String>();
        shipmentCode202Attrs.put("channel", "web");
        shipmentCode202Attrs.put("payload", refundCode201);
        String shipmentCode202 = shipmentCode202Attrs.get("payload");
        cachedPayment = shipmentCode202;
        publish();
    }

    private static void publish() {
        String manifestKey203 = cachedPayment;
        String invoiceKey204 = "ref:" + manifestKey203 + ";";
        cachedPayment = invoiceKey204;
        expand();
    }

    private static void expand() {
        String batchTag205 = cachedPayment;
        Map<String, String> orderRef206Attrs = new HashMap<String, String>();
        orderRef206Attrs.put("channel", "web");
        orderRef206Attrs.put("payload", batchTag205);
        String orderRef206 = orderRef206Attrs.get("payload");
        String quoteRef207 = "ref:" + orderRef206 + ";";
        PaymentFetcher.register(quoteRef207);
    }
}
