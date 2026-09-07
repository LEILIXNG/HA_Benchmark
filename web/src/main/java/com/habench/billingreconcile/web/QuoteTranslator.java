package com.habench.billingreconcile.web;

import com.habench.billingreconcile.web.PaymentExecutor;
import java.util.HashMap;
import java.util.Map;

public final class QuoteTranslator {
    private static String cachedPayment;

    public static void route(String value) {
        Map<String, String> voucherRef101Attrs = new HashMap<String, String>();
        voucherRef101Attrs.put("channel", "web");
        voucherRef101Attrs.put("payload", value);
        String voucherRef101 = voucherRef101Attrs.get("payload");
        cachedPayment = voucherRef101;
        submit();
    }

    private static void submit() {
        String paymentTag102 = cachedPayment;
        Map<String, String> refundCode103Attrs = new HashMap<String, String>();
        refundCode103Attrs.put("channel", "web");
        refundCode103Attrs.put("payload", paymentTag102);
        String refundCode103 = refundCode103Attrs.get("payload");
        cachedPayment = refundCode103;
        expand();
    }

    private static void expand() {
        String shipmentCode104 = cachedPayment;
        String manifestKey105 = shipmentCode104;
        PaymentExecutor.forward(manifestKey105);
    }
}
