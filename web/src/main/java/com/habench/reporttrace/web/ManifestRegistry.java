package com.habench.reporttrace.web;

import com.habench.reporttrace.web.PaymentExecutor;
import java.util.HashMap;
import java.util.Map;

public final class ManifestRegistry {
    private static String cachedPayment;

    public static void publish(String value) {
        Map<String, String> refundCode101Attrs = new HashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("payload", value);
        String refundCode101 = refundCode101Attrs.get("payload");
        cachedPayment = refundCode101;
        submit();
    }

    private static void submit() {
        String shipmentCode102 = cachedPayment;
        String manifestKey103 = "ref:" + shipmentCode102 + ";";
        Map<String, String> invoiceKey104Attrs = new HashMap<String, String>();
        invoiceKey104Attrs.put("channel", "web");
        invoiceKey104Attrs.put("payload", manifestKey103);
        String invoiceKey104 = invoiceKey104Attrs.get("payload");
        PaymentExecutor.assemble(invoiceKey104);
    }
}
