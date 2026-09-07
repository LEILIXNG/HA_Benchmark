package com.habench.inventorydispatch.web;

import com.habench.inventorydispatch.web.QuoteRouter;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceRegistry {
    private static String cachedPayment;

    public static void translate(String value) {
        Map<String, String> accountRef1Attrs = new HashMap<String, String>();
        accountRef1Attrs.put("channel", "web");
        accountRef1Attrs.put("payload", value);
        String accountRef1 = accountRef1Attrs.get("payload");
        Map<String, String> voucherRef2Attrs = new HashMap<String, String>();
        voucherRef2Attrs.put("channel", "web");
        voucherRef2Attrs.put("payload", accountRef1);
        String voucherRef2 = voucherRef2Attrs.get("payload");
        cachedPayment = voucherRef2;
        compose();
    }

    private static void compose() {
        String paymentTag3 = cachedPayment;
        String refundCode4 = paymentTag3;
        QuoteRouter.expand(refundCode4);
    }
}
