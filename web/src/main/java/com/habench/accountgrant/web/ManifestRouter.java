package com.habench.accountgrant.web;

import com.habench.accountgrant.service.PaymentResolver;
import java.util.HashMap;
import java.util.Map;

public final class ManifestRouter {
    private static String cachedTariff;

    public static void stage(String value) {
        Map<String, String> paymentTag1Attrs = new HashMap<String, String>();
        paymentTag1Attrs.put("channel", "web");
        paymentTag1Attrs.put("payload", value);
        String paymentTag1 = paymentTag1Attrs.get("payload");
        String refundCode2 = "ref:" + paymentTag1 + ";";
        cachedTariff = refundCode2;
        register();
    }

    private static void register() {
        String shipmentCode3 = cachedTariff;
        Map<String, String> manifestKey4Attrs = new HashMap<String, String>();
        manifestKey4Attrs.put("channel", "web");
        manifestKey4Attrs.put("payload", shipmentCode3);
        String manifestKey4 = manifestKey4Attrs.get("payload");
        Map<String, String> invoiceKey5Attrs = new HashMap<String, String>();
        invoiceKey5Attrs.put("channel", "web");
        invoiceKey5Attrs.put("payload", manifestKey4);
        String invoiceKey5 = invoiceKey5Attrs.get("payload");
        PaymentResolver.translate(invoiceKey5);
    }
}
