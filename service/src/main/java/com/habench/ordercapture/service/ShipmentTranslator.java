package com.habench.ordercapture.service;

import com.habench.ordercapture.service.InvoiceStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentTranslator {
    private static String cachedSession;

    public static void collect(String value) {
        String receiptKey201 = "ref:" + value + ";";
        String accountRef202 = "ref:" + receiptKey201 + ";";
        cachedSession = accountRef202;
        submit();
    }

    private static void submit() {
        String voucherRef203 = cachedSession;
        String paymentTag204 = "ref:" + voucherRef203 + ";";
        Map<String, String> refundCode205Attrs = new HashMap<String, String>();
        refundCode205Attrs.put("channel", "web");
        refundCode205Attrs.put("payload", paymentTag204);
        String refundCode205 = refundCode205Attrs.get("payload");
        InvoiceStrategySelector.publish(refundCode205);
    }
}
