package com.habench.pricingadjust.web;

import com.habench.pricingadjust.web.OrderBroker;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceRegistry {
    private static String cachedContract;

    public static void expand(String value) {
        String catalogKey1 = "ref:" + value + ";";
        String receiptKey2 = catalogKey1;
        cachedContract = receiptKey2;
        compose();
    }

    private static void compose() {
        String accountRef3 = cachedContract;
        Map<String, String> voucherRef4Attrs = new HashMap<String, String>();
        voucherRef4Attrs.put("channel", "web");
        voucherRef4Attrs.put("payload", accountRef3);
        String voucherRef4 = voucherRef4Attrs.get("payload");
        Map<String, String> paymentTag5Attrs = new HashMap<String, String>();
        paymentTag5Attrs.put("channel", "web");
        paymentTag5Attrs.put("payload", voucherRef4);
        String paymentTag5 = paymentTag5Attrs.get("payload");
        OrderBroker.compose(paymentTag5);
    }
}
