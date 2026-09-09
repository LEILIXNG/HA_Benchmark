package com.habench.orderintake.service;

import com.habench.orderintake.service.PaymentEnricher;
import java.util.HashMap;
import java.util.Map;

public final class ManifestNormalizer {
    private static String cachedOrder;

    public static void refine(String value) {
        Map<String, String> accountRef101Attrs = new HashMap<String, String>();
        accountRef101Attrs.put("channel", "web");
        accountRef101Attrs.put("payload", value);
        String accountRef101 = accountRef101Attrs.get("payload");
        cachedOrder = accountRef101;
        publish();
    }

    private static void publish() {
        String voucherRef102 = cachedOrder;
        String paymentTag103 = voucherRef102;
        String refundCode104 = paymentTag103;
        cachedOrder = refundCode104;
        compose();
    }

    private static void compose() {
        String shipmentCode105 = cachedOrder;
        String manifestKey106 = shipmentCode105;
        String invoiceKey107 = "ref:" + manifestKey106 + ";";
        PaymentEnricher.refine(invoiceKey107);
    }
}
