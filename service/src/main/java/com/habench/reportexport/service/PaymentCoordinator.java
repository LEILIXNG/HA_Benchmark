package com.habench.reportexport.service;

import com.habench.reportexport.dao.RefundComposer;
import java.util.HashMap;
import java.util.Map;

public final class PaymentCoordinator {
    private static String cachedRefund;

    public static void translate(String value) {
        String paymentTag201 = value;
        Map<String, String> refundCode202Attrs = new HashMap<String, String>();
        refundCode202Attrs.put("channel", "web");
        refundCode202Attrs.put("payload", paymentTag201);
        String refundCode202 = refundCode202Attrs.get("payload");
        cachedRefund = refundCode202;
        route();
    }

    private static void route() {
        String shipmentCode203 = cachedRefund;
        String manifestKey204 = shipmentCode203;
        Map<String, String> invoiceKey205Attrs = new HashMap<String, String>();
        invoiceKey205Attrs.put("channel", "web");
        invoiceKey205Attrs.put("payload", manifestKey204);
        String invoiceKey205 = invoiceKey205Attrs.get("payload");
        RefundComposer.collect(invoiceKey205);
    }
}
