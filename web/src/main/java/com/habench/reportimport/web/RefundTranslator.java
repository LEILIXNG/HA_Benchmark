package com.habench.reportimport.web;

import com.habench.reportimport.service.TariffEnricher;
import java.util.HashMap;
import java.util.Map;

public final class RefundTranslator {
    private static String cachedBundle;

    public static void resolve(String value) {
        Map<String, String> voucherRef1Attrs = new HashMap<String, String>();
        voucherRef1Attrs.put("channel", "web");
        voucherRef1Attrs.put("payload", value);
        String voucherRef1 = voucherRef1Attrs.get("payload");
        cachedBundle = voucherRef1;
        forward();
    }

    private static void forward() {
        String paymentTag2 = cachedBundle;
        String refundCode3 = paymentTag2;
        String shipmentCode4 = "ref:" + refundCode3 + ";";
        TariffEnricher.resolve(shipmentCode4);
    }
}
