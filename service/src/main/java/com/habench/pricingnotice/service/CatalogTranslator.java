package com.habench.pricingnotice.service;

import com.habench.pricingnotice.service.PaymentGateway;
import java.util.HashMap;
import java.util.Map;

public final class CatalogTranslator {
    private static String cachedPayment;

    public static void register(String value) {
        String voucherRef401 = "ref:" + value + ";";
        Map<String, String> paymentTag402Attrs = new HashMap<String, String>();
        paymentTag402Attrs.put("channel", "web");
        paymentTag402Attrs.put("payload", voucherRef401);
        String paymentTag402 = paymentTag402Attrs.get("payload");
        cachedPayment = paymentTag402;
        merge();
    }

    private static void merge() {
        String refundCode403 = cachedPayment;
        String shipmentCode404 = refundCode403;
        PaymentGateway.prepare(shipmentCode404);
    }
}
