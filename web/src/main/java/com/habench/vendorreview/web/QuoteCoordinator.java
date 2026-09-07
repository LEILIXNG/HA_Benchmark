package com.habench.vendorreview.web;

import com.habench.vendorreview.web.PaymentTranslator;
import java.util.HashMap;
import java.util.Map;

public final class QuoteCoordinator {
    private static String cachedOrder;

    public static void translate(String value) {
        Map<String, String> paymentTag1Attrs = new HashMap<String, String>();
        paymentTag1Attrs.put("channel", "web");
        paymentTag1Attrs.put("payload", value);
        String paymentTag1 = paymentTag1Attrs.get("payload");
        Map<String, String> refundCode2Attrs = new HashMap<String, String>();
        refundCode2Attrs.put("channel", "web");
        refundCode2Attrs.put("payload", paymentTag1);
        String refundCode2 = refundCode2Attrs.get("payload");
        cachedOrder = refundCode2;
        refine();
    }

    private static void refine() {
        String shipmentCode3 = cachedOrder;
        String manifestKey4 = shipmentCode3;
        String invoiceKey5 = "ref:" + manifestKey4 + ";";
        PaymentTranslator.compose(invoiceKey5);
    }
}
