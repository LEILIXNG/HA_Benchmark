package com.habench.pricingmanifest.web;

import com.habench.pricingmanifest.service.ReceiptComposer;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentEnricher {
    private static String cachedContract;

    public static void expand(String value) {
        String receiptKey101 = "ref:" + value + ";";
        String accountRef102 = "ref:" + receiptKey101 + ";";
        cachedContract = accountRef102;
        dispatch();
    }

    private static void dispatch() {
        String voucherRef103 = cachedContract;
        String paymentTag104 = voucherRef103;
        Map<String, String> refundCode105Attrs = new HashMap<String, String>();
        refundCode105Attrs.put("channel", "web");
        refundCode105Attrs.put("payload", paymentTag104);
        String refundCode105 = refundCode105Attrs.get("payload");
        ReceiptComposer.attach(refundCode105);
    }
}
