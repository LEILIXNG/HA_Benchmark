package com.habench.inventorysubmit.web;

import com.habench.inventorysubmit.service.PaymentFacade;
import java.util.HashMap;
import java.util.Map;

public final class OrderComposer {
    private static String cachedShipment;

    public static void register(String value) {
        Map<String, String> paymentTag1Attrs = new HashMap<String, String>();
        paymentTag1Attrs.put("channel", "web");
        paymentTag1Attrs.put("payload", value);
        String paymentTag1 = paymentTag1Attrs.get("payload");
        String refundCode2 = "ref:" + paymentTag1 + ";";
        cachedShipment = refundCode2;
        submit();
    }

    private static void submit() {
        String shipmentCode3 = cachedShipment;
        String manifestKey4 = "ref:" + shipmentCode3 + ";";
        String invoiceKey5 = "ref:" + manifestKey4 + ";";
        cachedShipment = invoiceKey5;
        dispatch();
    }

    private static void dispatch() {
        String batchTag6 = cachedShipment;
        String orderRef7 = batchTag6;
        String quoteRef8 = orderRef7;
        PaymentFacade.normalize(quoteRef8);
    }
}
